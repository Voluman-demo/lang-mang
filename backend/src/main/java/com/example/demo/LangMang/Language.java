package com.example.demo.LangMang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Language {
    private String code;

    public Language() {}

    public Language(String code) {
        this.code = code;
    }

}
