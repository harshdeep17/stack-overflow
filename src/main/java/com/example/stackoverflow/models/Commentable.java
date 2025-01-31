package com.example.stackoverflow.models;

import java.util.List;

public interface Commentable {
    public void addComment(Comment comment);
    public List<Comment> getComment();
}
