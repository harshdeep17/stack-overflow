package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class Base {
    private final String id;
    private final String createdAt;
    private String modifiedAt;
    public Base() {
        this.id = UUID.randomUUID().toString(); // Auto-generate ID
        this.createdAt = String.valueOf(LocalDateTime.now());
        this.modifiedAt = String.valueOf(LocalDateTime.now());
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }


}
