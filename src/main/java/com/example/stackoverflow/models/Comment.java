package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment extends Base {
    private String content;
    private User author;
}
