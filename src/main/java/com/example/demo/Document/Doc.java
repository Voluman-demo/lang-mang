package com.example.demo.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doc {
    private String languageCode;
    private String type;
    private List<Integer> version;  // x.y.z np. 1.0.2
    private String filePath;
}