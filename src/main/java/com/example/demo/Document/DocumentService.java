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

    private final Set<Doc> docs = new HashSet<>();

    public Set<Doc> getAllDocuments() {
        return docs;
    }

    public Set<Doc> getAllDocumentsByType(String documentType) {
        return docs.stream()
                .filter(doc -> doc.getType().equalsIgnoreCase(documentType))
                .collect(Collectors.toSet());
    }

    public void addDocument(String languageCode, String type, VersionChangeRequest versionChange, String fileName, InputStream fileStream) throws IOException {

        validateISO639_1Code(languageCode);


        // Upload pliku do Azure Blob Storage
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        if (!containerClient.exists()) {
            containerClient.create();
        }

        List<Integer> currentMaxVersion = getMaxVersionByType(type);
        List<Integer> newVersion = getNewVersion(versionChange, currentMaxVersion);

        if (isVersionDuplicate(type, newVersion, languageCode)) {
            throw new IllegalArgumentException("Dokument z tym typem i numerem wersji już istnieje.");
        }

        String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
        String baseFileName = fileName.substring(0, fileName.lastIndexOf(fileExtension));
        String cleanedBaseFileName = baseFileName.replaceAll("(_"+type+"_\\d+_\\d+_\\d+)+", "");
        String newFileName = cleanedBaseFileName + "_" + type + "_" + newVersion.get(0) + "_" + newVersion.get(1) + "_" + newVersion.get(2) + fileExtension;

        BlobClient blobClient = containerClient.getBlobClient(newFileName);
        blobClient.upload(fileStream, fileStream.available(), true);

        // Dodanie dokumentu do listy
        String fileUrl = blobClient.getBlobUrl();
        Doc doc = new Doc(languageCode, type, newVersion, fileUrl);
        docs.add(doc);
    }

    private List<Integer> getNewVersion(VersionChangeRequest version, List<Integer> currentMaxVersion) {
        List<Integer> newVersion = new ArrayList<>(currentMaxVersion);
        if (version == VersionChangeRequest.EQUALIZATION) {
            newVersion = currentMaxVersion;
        } else if (version == VersionChangeRequest.INCREASE_PATCH) {
            newVersion.set(2, currentMaxVersion.get(2) + 1);
        } else if (version == VersionChangeRequest.INCREASE_MINOR) {
            newVersion.set(1, currentMaxVersion.get(1) + 1);
            newVersion.set(2, 1);
        } else if (version == VersionChangeRequest.INCREASE_MAJOR) {
            newVersion.set(0, currentMaxVersion.get(0) + 1);
            newVersion.set(1, 0);
            newVersion.set(2, 1);
        }
        return newVersion;
    }

    private boolean isVersionDuplicate(String type, List<Integer> version, String languageCode) {
        return docs.stream()
                .anyMatch(doc ->
                        doc.getType().equals(type) &&
                                doc.getVersion().equals(version) &&
                                doc.getLanguageCode().equals(languageCode)
                );
    }

    private List<Integer> getMaxVersionByType(String type) {
        return docs.stream()
                .filter(doc -> doc.getType().equals(type))
                .map(Doc::getVersion)
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

    public List<Doc> getOutdatedDocuments(Set<Doc> allDocs) {
        List<Doc> outdatedDocs = new ArrayList<>();
        Map<String, List<Doc>> documentsByType = new HashMap<>();
        // Grupowanie dokumentów po typie
        for (Doc doc : allDocs) {
            documentsByType
                    .computeIfAbsent(doc.getType(), k -> new ArrayList<>())
                    .add(doc);
        }
        // Dla każdego typu dokumentów, znalezienie najnowszego dokumentu i usunięcie go z listy
        for (Map.Entry<String, List<Doc>> typeEntry : documentsByType.entrySet()) {
            List<Doc> documentsForType = typeEntry.getValue();
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
            Map<String, Doc> latestDocumentsByLanguage = new HashMap<>();
            // Przechodzimy przez dokumenty i wybieramy najnowszy dokument dla każdego języka
            for (Doc doc : documentsForType) {
                Doc existingLatest = latestDocumentsByLanguage.get(doc.getLanguageCode());
                if (existingLatest == null || compareVersions(doc.getVersion(), existingLatest.getVersion()) > 0) {
                    latestDocumentsByLanguage.put(doc.getLanguageCode(), doc);
                }
            }
            // Dodanie najnowszych dokumentów (po jednym dla każdego języka) do finalnej listy
            outdatedDocs.addAll(latestDocumentsByLanguage.values());
//            // Usunięcie najbardziej aktualnego dokumentu z listy
//            if (!documentsForType.isEmpty()) {
//                Document latestDocument = documentsForType.get(0);
//                documentsForType.remove(latestDocument);
//            }
            // Usunięcie wszystkich dokumentów z najnowszym numerem wersji
            if (!outdatedDocs.isEmpty()) {
                // Posortowanie dokumentów w porządku malejącym, aby pierwszy dokument był najnowszy
                outdatedDocs.sort((doc1, doc2) -> {
                    for (int i = 0; i < 3; i++) {
                        int comparison = doc2.getVersion().get(i).compareTo(doc1.getVersion().get(i)); // descending order
                        if (comparison != 0) {
                            return comparison;
                        }
                    }
                    return 0;
                });
                // Najnowszy dokument (pierwszy po posortowaniu)
                Doc latestDoc = outdatedDocs.get(0);
                // Usuwanie wszystkich dokumentów o tej samej wersji co najnowszy dokument
                outdatedDocs.removeIf(doc -> doc.getVersion().equals(latestDoc.getVersion()));
            }
        }
        return outdatedDocs;
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
