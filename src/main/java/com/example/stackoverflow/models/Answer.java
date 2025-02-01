package com.example.stackoverflow.models;


import java.util.ArrayList;
import java.util.List;

public class Answer extends Base implements Commentable, Votable {
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted;
    private List<Vote> votes;
    private List<Comment> comments;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
        this.votes.add(newVote);
        author.updateReputation(value * 5);
    }
    public void markAsAccepted(User user){
        if(this.question.getAuthor().equals(user)){
            if (isAccepted) {
                throw new IllegalStateException("This answer is already accepted");
            }
            this.setAccepted(true);
            author.updateReputation(15);
        } else {
            throw new IllegalArgumentException("User must be author of the question");
        }
    }
    public int getVoteCount(){
        int voteCount = 0;
        for(Vote vote:this.getVotes()){
            voteCount += vote.getValue();
        }
        return voteCount;
    }
}
