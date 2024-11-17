package com.example.demo.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private String languageCode;
    private String type;
    private int version;
    private String filePath;
}