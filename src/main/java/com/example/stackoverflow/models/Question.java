package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question extends Base implements Commentable, Votable {
    private String title;
    private String content;
    private User author;
    private List<Answer> answers;
    private List<Tag> tags;
    private List<Comment> comments;
    private List<Vote> votes;
    public void handleVote(User user, int value){
        Vote newVote = new Vote();
        newVote.setVotedBy(user);
        newVote.setValue(value);
    }

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
