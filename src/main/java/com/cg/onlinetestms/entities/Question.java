package com.cg.onlinetestms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Question {
	@Id
	@GeneratedValue
	private int questionId;
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	@JoinColumn(name = "question_options")
	private QuestionOptions questionOptions;
	private String questionTitle;
	private Integer questionAnswer;
	private int chosenAnswer;
	@JsonIgnore// to ignore the logical property used in serialization and des
	@ManyToOne(cascade = CascadeType.PERSIST)

	private Test test;

	public Question() {
		super();

	}

	public Question(int questionId, QuestionOptions questionOptions, String questionTitle, Integer questionAnswer,
			int chosenAnswer, Test test) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.chosenAnswer = chosenAnswer;
		this.test = test;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionOptions=" + questionOptions + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", chosenAnswer=" + chosenAnswer + ", test="
				+ test + "]";
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public QuestionOptions getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(QuestionOptions questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}