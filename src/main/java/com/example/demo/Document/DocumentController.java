<<<<<<< HEAD
//package com.example.demo.Document;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api/documents")
//public class DocumentController {
//
//    private final DocumentService documentService;
//
//    public DocumentController(DocumentService documentService) {
//        this.documentService = documentService;
//    }
//
//    @GetMapping
//    public Set<Document> getAllDocuments(@RequestParam(value = "type", required = false) String type) {
//        Set<Document> documents;
//        if (type != null && !type.isEmpty()) {
//            documents = documentService.getAllDocumentsByType(type);
//        } else {
//            documents = documentService.getAllDocuments();
//        }
//
//        return documents;
//    }
//
//    @GetMapping("/check")
//    public ResponseEntity<List<Document>> checkOutdatedDocuments(@RequestParam(value = "type", required = false) String type) {
//        try {
//            Set<Document> documents;
//            if (type != null && !type.isEmpty()) {
//                documents = documentService.getAllDocumentsByType(type);
//            } else {
//                documents = documentService.getAllDocuments();
//            }
//            List<Document> outdatedDocuments = documentService.getOutdatedDocuments(documents);
//            return ResponseEntity.ok(outdatedDocuments);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<String> addDocument(@RequestParam("file") MultipartFile file,
//                                              @RequestParam("languageCode") String languageCode,
//                                              @RequestParam("type") String type,
//                                              @RequestParam("version") VersionRequest version) {
//        try {
//            String fileName = file.getOriginalFilename();
//            InputStream fileStream = file.getInputStream();
//
//            documentService.addDocument(languageCode, type, version, fileName, fileStream);
//
//            return ResponseEntity.ok("Dokument został dodany do Azure Blob Storage.");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błąd przy zapisie pliku.");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/file/{filename}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
//        try {
//            String fileUrl = documentService.getAllDocuments().stream()
//                    .filter(doc -> doc.getFilePath().contains(filename))
//                    .map(Document::getFilePath)
//                    .findFirst()
//                    .orElseThrow(() -> new FileNotFoundException("Plik nie znaleziony: " + filename));
//
//            UrlResource resource = new UrlResource(new URL(fileUrl));
//
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } catch (MalformedURLException | FileNotFoundException e) {
//            throw new RuntimeException("Błąd podczas pobierania pliku: " + filename, e);
//        }
//    }
//}
=======
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
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
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            InputStream fileStream = file.getInputStream();

            documentService.addDocument(languageCode, type, fileName, fileStream);

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
                    .map(Document::getFilePath)
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
}
>>>>>>> parent of 14dadb2 (documents mang: fix errors and add features)
