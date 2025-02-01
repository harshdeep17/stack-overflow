package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }


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
    public List<Comment> getAllComments() {
        return new ArrayList<>(this.comments);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        Vote newVote = new Vote();
        newVote.setVotedBy(user);
        newVote.setValue(value);
        votes.removeIf(v -> v.getVotedBy().equals(user));
        this.getVotes().add(newVote);
        author.updateReputation(value * 5);
    }
    public int getVoteCount(){
        int voteCount = 0;
        for(Vote vote:this.getVotes()){
            voteCount += vote.getValue();
        }
        return voteCount;
    }
}
