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

    private final List<Document> documents = new ArrayList<>();

    public List<Document> getAllDocuments() {
        return documents;
    }

    public void addDocument(String languageCode, String type, String fileName, InputStream fileStream) throws IOException {
        validateISO639_1Code(languageCode);

        // Upload pliku do Azure Blob Storage
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        if (!containerClient.exists()) {
            containerClient.create();
        }

<<<<<<< HEAD
        List<Integer> currentMaxVersion = getMaxVersionByType(type);

        List<Integer> newVersion = getNewVersion(version, currentMaxVersion);

        if (isVersionDuplicate(type, newVersion, languageCode)) {
            throw new IllegalArgumentException("Dokument z tym typem i numerem wersji już istnieje.");
        }

        String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
        String baseFileName = fileName.substring(0, fileName.lastIndexOf(fileExtension));
        String newFileName = baseFileName + "_" + type + "_" + newVersion.get(0) + "_" + newVersion.get(1) + "_" + newVersion.get(2) + fileExtension;

        BlobClient blobClient = containerClient.getBlobClient(newFileName);
=======
        BlobClient blobClient = containerClient.getBlobClient(fileName);
>>>>>>> parent of 14dadb2 (documents mang: fix errors and add features)
        blobClient.upload(fileStream, fileStream.available(), true);

        // Dodanie dokumentu do listy
        String fileUrl = blobClient.getBlobUrl();
        Document document = new Document(languageCode, type, 0, fileUrl);
        documents.add(document);
    }

<<<<<<< HEAD
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

=======
>>>>>>> parent of 14dadb2 (documents mang: fix errors and add features)
    public void validateISO639_1Code(String code) {
        if (code == null || code.length() != 2 || !isISO639_1Code(code)) {
            throw new IllegalArgumentException("Nieprawidłowy kod ISO 639-1: " + code);
        }
    }

    private boolean isISO639_1Code(String code) {
        return List.of(Locale.getISOLanguages()).contains(code.toLowerCase());
    }

    public List<String> checkOutdatedDocuments() {
        Map<String, Integer> latestVersions = documents.stream()
                .collect(Collectors.groupingBy(
                        Document::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Document::getVersion)),
                                optionalDoc -> optionalDoc.map(Document::getVersion).orElse(0)
                        )
                ));

        return documents.stream()
                .filter(doc -> doc.getVersion() < latestVersions.get(doc.getType()))
                .map(doc -> "Nieaktualny dokument: " + doc.getType() + " (" + doc.getLanguageCode() + "), wersja: " + doc.getVersion())
                .collect(Collectors.toList());
    }
}
