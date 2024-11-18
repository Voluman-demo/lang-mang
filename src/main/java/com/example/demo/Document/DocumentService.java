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

        BlobClient blobClient = containerClient.getBlobClient(fileName);
        blobClient.upload(fileStream, fileStream.available(), true);

        // Dodanie dokumentu do listy
        String fileUrl = blobClient.getBlobUrl();
        Document document = new Document(languageCode, type, 0, fileUrl);
        documents.add(document);
    }

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
