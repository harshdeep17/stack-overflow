package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment extends Base {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    private User author;
}
