package com.example.demo.Document;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Value("${azure.storage.container-name}")
    private String containerName;

    private final Set<Document> documents = new HashSet<>();

    public Set<Document> getAllDocuments() {
        return documents;
    }

    public Set<Document> getAllDocumentsByType(String documentType) {
        return documents.stream()
                .filter(doc -> doc.getType().equalsIgnoreCase(documentType))
                .collect(Collectors.toSet());
    }

    public void addDocument(String languageCode, String type, VersionRequest version, String fileName, InputStream fileStream) throws IOException {
        validateISO639_1Code(languageCode);

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        if (!containerClient.exists()) {
            containerClient.create();
        }

        List<Integer> currentMaxVersion = getMaxVersionByType(type);

        List<Integer> newVersion = getNewVersion(version, currentMaxVersion);

        if (isVersionDuplicate(type, newVersion, languageCode)) {
            throw new IllegalArgumentException("Dokument z tym typem i numerem wersji już istnieje.");
        }

        String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
        String baseFileName = fileName.substring(0, fileName.lastIndexOf(fileExtension));
        String newFileName = baseFileName + "_" + type + "_" + newVersion.get(0) + "_" + newVersion.get(1) + "_" + newVersion.get(2) + fileExtension;

        BlobClient blobClient = containerClient.getBlobClient(newFileName);
        blobClient.upload(fileStream, fileStream.available(), true);

        String fileUrl = blobClient.getBlobUrl();


        Document document = new Document(languageCode, type, newVersion, fileUrl);
        documents.add(document);
    }

    private List<Integer> getNewVersion(VersionRequest version, List<Integer> currentMaxVersion) {
        List<Integer> newVersion = new ArrayList<>(currentMaxVersion);
        if (version == VersionRequest.EQUALIZATION) {
            newVersion = currentMaxVersion;
        } else if (version == VersionRequest.INCREASE_PATCH) {
            newVersion.set(2, currentMaxVersion.get(2) + 1);
        } else if (version == VersionRequest.INCREASE_MINOR) {
            newVersion.set(1, currentMaxVersion.get(1) + 1);
            newVersion.set(2, 1);
        } else if (version == VersionRequest.INCREASE_MAJOR) {
            newVersion.set(0, currentMaxVersion.get(0) + 1);
            newVersion.set(1, 0);
            newVersion.set(2, 1);
        }
        return newVersion;
    }

    private boolean isVersionDuplicate(String type, List<Integer> version, String languageCode) {
        return documents.stream()
                .anyMatch(doc ->
                        doc.getType().equals(type) &&
                        doc.getVersion().equals(version) &&
                        doc.getLanguageCode().equals(languageCode)
                );
    }

    private List<Integer> getMaxVersionByType(String type) {
        return documents.stream()
                .filter(doc -> doc.getType().equals(type))
                .map(Document::getVersion)
                .max(Comparator.comparingInt((List<Integer> version) -> version.get(0))
                        .thenComparingInt(version -> version.get(1))
                        .thenComparingInt(version -> version.get(2)))
                .orElse(Arrays.asList(1, 0, 1));
    }

    public void validateISO639_1Code(String code) {
        if (code == null || code.length() != 2 || !isISO639_1Code(code)) {
            throw new IllegalArgumentException("Nieprawidłowy kod ISO 639-1: " + code);
        }
    }

    private boolean isISO639_1Code(String code) {
        return List.of(Locale.getISOLanguages()).contains(code.toLowerCase());
    }

    public List<Document> getOutdatedDocuments(Set<Document> allDocuments) {
        List<Document> outdatedDocuments = new ArrayList<>();

        Map<String, List<Document>> documentsByType = new HashMap<>();

        // Grupowanie dokumentów po typie
        for (Document doc : allDocuments) {
            documentsByType
                    .computeIfAbsent(doc.getType(), k -> new ArrayList<>())
                    .add(doc);
        }

        // Dla każdego typu dokumentów, znalezienie najnowszego dokumentu i usunięcie go z listy
        for (Map.Entry<String, List<Document>> typeEntry : documentsByType.entrySet()) {
            List<Document> documentsForType = typeEntry.getValue();

            // Sortowanie dokumentów według wersji (malejąco)
            documentsForType.sort((doc1, doc2) -> {
                for (int i = 0; i < 3; i++) {
                    int comparison = doc2.getVersion().get(i).compareTo(doc1.getVersion().get(i)); // descending order
                    if (comparison != 0) {
                        return comparison;
                    }
                }
                return 0;
            });

            // Mapa przechowująca najnowszy dokument dla każdego języka
            Map<String, Document> latestDocumentsByLanguage = new HashMap<>();

            // Przechodzimy przez dokumenty i wybieramy najnowszy dokument dla każdego języka
            for (Document doc : documentsForType) {
                Document existingLatest = latestDocumentsByLanguage.get(doc.getLanguageCode());
                if (existingLatest == null || compareVersions(doc.getVersion(), existingLatest.getVersion()) > 0) {
                    latestDocumentsByLanguage.put(doc.getLanguageCode(), doc);
                }
            }

            // Dodanie najnowszych dokumentów (po jednym dla każdego języka) do finalnej listy
            outdatedDocuments.addAll(latestDocumentsByLanguage.values());

//            // Usunięcie najbardziej aktualnego dokumentu z listy
//            if (!documentsForType.isEmpty()) {
//                Document latestDocument = documentsForType.get(0);
//                documentsForType.remove(latestDocument);
//            }
            // Usunięcie wszystkich dokumentów z najnowszym numerem wersji
            if (!outdatedDocuments.isEmpty()) {
                // Posortowanie dokumentów w porządku malejącym, aby pierwszy dokument był najnowszy
                outdatedDocuments.sort((doc1, doc2) -> {
                    for (int i = 0; i < 3; i++) {
                        int comparison = doc2.getVersion().get(i).compareTo(doc1.getVersion().get(i)); // descending order
                        if (comparison != 0) {
                            return comparison;
                        }
                    }
                    return 0;
                });

                // Najnowszy dokument (pierwszy po posortowaniu)
                Document latestDocument = outdatedDocuments.get(0);

                // Usuwanie wszystkich dokumentów o tej samej wersji co najnowszy dokument
                outdatedDocuments.removeIf(doc -> doc.getVersion().equals(latestDocument.getVersion()));
            }
        }

        return outdatedDocuments;
    }

    // Porównanie wersji dokumentów
    private int compareVersions(List<Integer> version1, List<Integer> version2) {
        for (int i = 0; i < version1.size(); i++) {
            int result = version1.get(i).compareTo(version2.get(i));
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}
