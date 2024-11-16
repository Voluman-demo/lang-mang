package com.example.demo.LangMang;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LangMangController {
    private final LangMangService langMangService;

    public LangMangController(LangMangService langMangService) {
        this.langMangService = langMangService;
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return langMangService.getAllLanguages();
    }

    @PostMapping
    public ResponseEntity<String> addLanguage(@RequestBody Language language) {
        try {
            langMangService.validateISO639_1Code(language.getCode());
            langMangService.validateLanguageNotExists(language.getCode());
            langMangService.addLanguage(language);
            return ResponseEntity.ok("");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> removeLanguage(@PathVariable String code) {
        try {
            langMangService.validateLanguageExists(code);
            langMangService.removeLanguage(code);
            return ResponseEntity.ok("");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearLanguages() {
        langMangService.clearLanguages();
        return ResponseEntity.ok("");
    }
}