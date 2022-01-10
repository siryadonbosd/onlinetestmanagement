package com.cg.onlinetestms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetestms.dao.QuestionDao;
import com.cg.onlinetestms.entities.Question;
import com.cg.onlinetestms.exception.QuestionNotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao qDao;

	public Question addQuestion(Question question) {
		return qDao.save(question);

	}

	public Question updateQuestion(Question question) {
		Optional<Question> op = qDao.findById(question.getQuestionId());
		Question updatedQuestion = op.get();
		updatedQuestion.setChosenAnswer(question.getChosenAnswer());
		updatedQuestion.setQuestionAnswer(question.getQuestionAnswer());
		updatedQuestion.setQuestionOptions(question.getQuestionOptions());
		updatedQuestion.setQuestionTitle(question.getQuestionTitle());
		return qDao.save(updatedQuestion);
	}

	@Override
	public Question deleteQuestion(int id) {
		Optional<Question> op = qDao.findById(id);
		if (!op.isPresent()) {
			throw new QuestionNotFoundException("No question found for id: " + id);
		}
		Question deletedQuestion = op.get();
		qDao.deleteById(id);
		return deletedQuestion;
	}

}
