package com.example.demo.LangMang;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class LangMangService {
    private final List<Language> languages = new ArrayList<>();

    public List<Language> getAllLanguages() {
        return languages;
    }

    public void addLanguage(Language language) {
        language.setCode(language.getCode().trim().toLowerCase());
        languages.add(language);
    }

    public void removeLanguage(String code) {
        languages.removeIf(lang -> lang.getCode().equalsIgnoreCase(code));
    }

    public void clearLanguages() {
        languages.clear();
    }

    public void validateLanguageNotExists(String code) {
        if (languages.stream().anyMatch(lang -> lang.getCode().equalsIgnoreCase(code))) {
            throw new IllegalArgumentException("Jezyk o kodzie " + code + " juz istnieje.");
        }
    }

    public void validateLanguageExists(String code) {
        if (languages.stream().noneMatch(lang -> lang.getCode().equalsIgnoreCase(code))) {
            throw new IllegalArgumentException("Jezyk o kodzie " + code + " nie istnieje.");
        }
    }

    public void validateISO639_1Code(String code) {
        if (code == null || code.length() != 2 || !isISO639_1Code(code)) {
            throw new IllegalArgumentException("Nieprawidlowy kod ISO 639-1: " + code);
        }
    }

    private boolean isISO639_1Code(String code) {
        Locale.getISOLanguages();
        return List.of(Locale.getISOLanguages()).contains(code.toLowerCase());
    }
}
