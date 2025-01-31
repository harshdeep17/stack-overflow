package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User extends Base {
    private String username;
    private String email;
    private int reputationScore;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;
    public void addQuestion(String title, String content, List<Tag> tags){
        Question newQuestion = new Question();
        newQuestion.setTitle(title);
        newQuestion.setContent(content);
        newQuestion.setTags(tags);
        newQuestion.setAuthor(this);
        this.questions.add(newQuestion);
        this.updateReputation(QUESTION_REPUTATION);
    }
    public void addAnswer(Question question, String content){
        Answer newAnswer = new Answer();
        newAnswer.setContent(content);
        newAnswer.setAuthor(this);
        newAnswer.setQuestion(question);
        newAnswer.setAccepted(false);
        question.getAnswers().add(newAnswer);
        this.answers.add(newAnswer);
        this.updateReputation(ANSWER_REPUTATION);
    }
    public void addComment(Commentable commentable, String content){
        Comment newComment = new Comment();
        newComment.setContent(content);
        newComment.setAuthor(this);
        commentable.addComment(newComment);
        this.comments.add(newComment);
        this.updateReputation(COMMENT_REPUTATION);
    }

    public synchronized void updateReputation(int reputationScore){
        this.setReputationScore(this.getReputationScore() + reputationScore);
    }

}
