package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tag extends Base {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
