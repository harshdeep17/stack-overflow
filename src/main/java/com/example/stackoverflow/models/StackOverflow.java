package com.example.stackoverflow.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email){
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setReputationScore(0);
        newUser.setQuestions(new ArrayList<>());
        newUser.setAnswers(new ArrayList<>());
        newUser.setComments(new ArrayList<>());
        users.put(newUser.getId(), newUser);
        return newUser;
    }
    public Question askQuestion(User user, String title, String content, List<String> tags){
        List<Tag> newTags = new ArrayList<>();
        for(String tag:tags){
            Tag newTag = new Tag();
            newTag.setName(tag);
            newTags.add(newTag);
        }
        Question newQuestion = user.addQuestion(title, content, newTags);
        questions.put(newQuestion.getId(), newQuestion);
        for(Tag tag: newQuestion.getTags()){
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return newQuestion;
    }
    public Answer answerQuestion(User user, Question question, String content){
        Answer newAnswer = user.addAnswer(question, content);
        answers.put(newAnswer.getId(), newAnswer);
        return newAnswer;
    }
    public Comment addComment(User user, Commentable commentable, String comment){
        return user.addComment(commentable, comment);
    }

    public void voteQuestion(User user, Votable votable, int value){
        votable.vote(user, value);
    }
    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(user, value);
    }

    public void acceptAnswer(User user,Answer answer) {
        answer.markAsAccepted(user);
    }
    public List<Question> searchQuestions(String query){
        return this.questions.values().stream()
                .filter(question -> question.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        question.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        question.getTags().stream().anyMatch(tag -> tag.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }
    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }
}
