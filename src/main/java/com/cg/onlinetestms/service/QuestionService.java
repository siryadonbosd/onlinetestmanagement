package com.cg.onlinetestms.service;

import com.cg.onlinetestms.entities.Question;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Question deleteQuestion(int id);

}
