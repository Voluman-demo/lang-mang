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
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public Set<Doc> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @PostMapping
    public ResponseEntity<String> addDocument(@RequestParam("file") MultipartFile file,
                                              @RequestParam("languageCode") String languageCode,
                                              @RequestParam("type") String type,
                                              @RequestParam("version") VersionChangeRequest version) {
        try {
            String fileName = file.getOriginalFilename();
            InputStream fileStream = file.getInputStream();

            documentService.addDocument(languageCode, type, version,fileName, fileStream);

            return ResponseEntity.ok("Dokument został dodany do Azure Blob Storage.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błąd przy zapisie pliku.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            String fileUrl = documentService.getAllDocuments().stream()
                    .filter(doc -> doc.getFilePath().contains(filename))
                    .map(Doc::getFilePath)
                    .findFirst()
                    .orElseThrow(() -> new FileNotFoundException("Plik nie znaleziony: " + filename));

            UrlResource resource = new UrlResource(new URL(fileUrl));

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedURLException | FileNotFoundException e) {
            throw new RuntimeException("Błąd podczas pobierania pliku: " + filename, e);
        }
    }

    @GetMapping("/check")
    public ResponseEntity<List<Doc>> checkOutdatedDocuments(@RequestParam(value = "type", required = false) String type) {
        try {
            Set<Doc> docs;
            if(type != null && !type.isEmpty()) {
                docs = documentService.getAllDocumentsByType(type);
            } else {
                docs = documentService.getAllDocuments();
            }
            List<Doc> outdatedDocs = documentService.getOutdatedDocuments(docs);
            return ResponseEntity.ok(outdatedDocs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
