package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Answer extends Base implements Commentable, Votable {
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted;
    private List<Comment> comments;
    private List<Vote> votes;

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComment() {
        return this.getComments();
    }

    @Override
    public void vote(User user, int value) {
        Vote newVote = new Vote();
        newVote.setVotedBy(user);
        newVote.setValue(value);
        this.getVotes().add(newVote);
    }
}
