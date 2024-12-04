package com.example.demo.Document;


public enum VersionChangeRequest {
    EQUALIZATION,        // Wyrównanie wersji
    INCREASE_PATCH,      // (x.y.z+1)
    INCREASE_MINOR,      // (x.y+1.z)
    INCREASE_MAJOR       // (x+1.y.z)
}