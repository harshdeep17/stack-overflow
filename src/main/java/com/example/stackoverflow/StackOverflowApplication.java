package com.example.stackoverflow;

import com.example.stackoverflow.models.Answer;
import com.example.stackoverflow.models.Question;
import com.example.stackoverflow.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StackOverflowApplication {
	public void voteQuestion(User user, Question question, int value) {
		question.vote(user, value);
	}
	public void voteAnswer(User user, Answer answer, int value) {
		answer.vote(user, value);
	}
	public static void main(String[] args) {
		SpringApplication.run(StackOverflowApplication.class, args);



	}

}
