package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class User extends Base {
    private String username;
    private String email;
    private int reputationScore;
    private List<Question> questions;
    private List<Answer> answers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(int reputationScore) {
        this.reputationScore = reputationScore;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    private List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;
    public Question addQuestion(String title, String content, List<Tag> tags){
        Question newQuestion = new Question();
        newQuestion.setTitle(title);
        newQuestion.setContent(content);
        newQuestion.setTags(tags);
        newQuestion.setAuthor(this);
        newQuestion.setAnswers(new ArrayList<>());
        newQuestion.setComments(new ArrayList<>());
        newQuestion.setVotes(new ArrayList<>());
        this.questions.add(newQuestion);
        this.updateReputation(QUESTION_REPUTATION);
        return newQuestion;
    }
    public Answer addAnswer(Question question, String content){
        Answer newAnswer = new Answer();
        newAnswer.setContent(content);
        newAnswer.setAuthor(this);
        newAnswer.setQuestion(question);
        newAnswer.setAccepted(false);
        newAnswer.setComments(new ArrayList<>());
        newAnswer.setVotes(new ArrayList<>());
        question.getAnswers().add(newAnswer);
        this.answers.add(newAnswer);
        this.updateReputation(ANSWER_REPUTATION);
        return newAnswer;
    }
    public Comment addComment(Commentable commentable, String content){
        Comment newComment = new Comment();
        newComment.setContent(content);
        newComment.setAuthor(this);
        commentable.addComment(newComment);
        this.comments.add(newComment);
        this.updateReputation(COMMENT_REPUTATION);
        return newComment;
    }

    public synchronized void updateReputation(int reputationScore){
        this.setReputationScore(this.getReputationScore() + reputationScore);
    }

}
