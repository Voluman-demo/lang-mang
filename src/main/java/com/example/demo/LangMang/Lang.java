package com.example.demo.LangMang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lang {
    private String code;

    public Lang() {}

    public Lang(String code) {
        this.code = code;
    }


}
