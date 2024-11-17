package com.example.demo.Document;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;
    private final Path uploadDir;

    public DocumentController(DocumentService documentService, Path uploadDir) {
        this.documentService = documentService;
        this.uploadDir = uploadDir;
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @PostMapping
    public ResponseEntity<String> addDocument(@RequestParam("file") MultipartFile file,
                                              @RequestParam("languageCode") String languageCode,
                                              @RequestParam("type") String type) {
        try {
            // Tworzenie katalogu, jeśli nie istnieje
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Tworzymy unikalną nazwę pliku
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path targetLocation = uploadDir.resolve(fileName);

            // Zapisanie pliku
            file.transferTo(targetLocation);

            // Tworzenie dokumentu i zapisanie go w bazie
            documentService.addDocument(languageCode, type, targetLocation.toString());

            return ResponseEntity.ok("Dokument został dodany.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błąd przy zapisie pliku.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/check")
    public List<String> checkOutdatedDocuments() {
        return documentService.checkOutdatedDocuments();
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Path filePath = Paths.get("uploads").resolve(filename).normalize();
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new FileNotFoundException("Plik nie znaleziony: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Błąd podczas pobierania pliku: " + filename, e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
