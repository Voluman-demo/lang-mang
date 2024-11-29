package com.example.demo.Rpc;

import com.example.demo.Document.Document;
import com.example.demo.Document.DocumentService;
import com.example.demo.Document.VersionRequest;
import com.example.demo.LangMang.LangMangService;
import com.example.demo.LangMang.Language;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;


@Service
public class RpcService {
    private final DocumentService documentService;
    private final LangMangService langMangService;

    public RpcService(DocumentService documentService, LangMangService langMangService) {
        this.documentService = documentService;
        this.langMangService = langMangService;
    }


    ResponseEntity<?> handleGetAllDocuments(Map<String, String> params) {
        String type = params.get("type");
        Set<Document> documents = (type != null && !type.isEmpty())
                ? documentService.getAllDocumentsByType(type)
                : documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    public ResponseEntity<?> handleGetAllLanguages() {
        List<Language> languages = langMangService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }

    public ResponseEntity<?> handleAddLanguage(Map<String, String> params) {
        try {
            String code = params.get("code");
            Language language = new Language(code);
            langMangService.validateISO639_1Code(language.getCode());
            langMangService.validateLanguageNotExists(language.getCode());
            langMangService.addLanguage(language);
            return ResponseEntity.ok("Jezyk zostal dodany");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Jezyk juz istnieje");
        }
    }

    public ResponseEntity<?> removeLanguage(Map<String, String> params) {
        String code = params.get("code");
        try {
            langMangService.validateLanguageExists(code);
            langMangService.removeLanguage(code);
            return ResponseEntity.ok("Jezyk zostal usuniety!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<String> clearLanguages() {
        langMangService.clearLanguages();
        return ResponseEntity.ok("Jezyki zostaly usuniete!");
    }

    public ResponseEntity<?> handleGetOutdatedDocuments(Map<String, String> params) {
        String type = params.get("type");
        Set<Document> documents = (type != null && !type.isEmpty())
                ? documentService.getAllDocumentsByType(type)
                : documentService.getAllDocuments();
        List<Document> outdatedDocuments = documentService.getOutdatedDocuments(documents);
        return ResponseEntity.ok(outdatedDocuments);
    }

    public ResponseEntity<?> handleAddDocument(Map<String, String> params, MultipartFile file) {
        try {
            String languageCode = params.get("documentLanguage");
            String type = params.get("documentType");
            VersionRequest version = VersionRequest.valueOf(params.get("versionOption"));
            

            String fileName = file.getOriginalFilename();
            InputStream fileStream = file.getInputStream();

            documentService.addDocument(languageCode, type, version, fileName, fileStream);
            return ResponseEntity.ok("Dokument został dodany do Azure Blob Storage.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błąd przy zapisie pliku.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<?> handleDownloadFile(Map<String, String> params) {
        String filename = params.get("fileName");
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
