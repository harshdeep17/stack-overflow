package com.example.stackoverflow.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Base {
    private final String id;
    private final String createdAt;
    private String modifiedAt;
    public Base() {
        this.id = UUID.randomUUID().toString(); // Auto-generate ID
        this.createdAt = String.valueOf(LocalDateTime.now());
        this.modifiedAt = String.valueOf(LocalDateTime.now());
    }
}
