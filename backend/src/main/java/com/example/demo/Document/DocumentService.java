package com.example.demo.Document;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    @Value("${document.upload-dir}")
    private String uploadDir;

    private final List<Document> documents = new ArrayList<>();

    public List<Document> getAllDocuments() {
        return documents;
    }

    public void addDocument(String languageCode, String type, String filePath) {
        // Sprawdzenie poprawności kodu języka
        validateISO639_1Code(languageCode);

        // Dodanie dokumentu do listy (lub bazy danych)
        Document document = new Document(languageCode, type, 0, filePath);
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

