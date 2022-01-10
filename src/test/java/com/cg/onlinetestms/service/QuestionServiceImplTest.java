package com.cg.onlinetestms.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.onlinetestms.entities.Question;
import com.cg.onlinetestms.entities.QuestionOptions;


@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(QuestionServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionServiceImplTest {
	@Autowired
	private QuestionService questionService;

	@Test
	public void testAddQuestion() {
		Question question = new Question(0, new QuestionOptions("3", "1", "4", "7", null), "apptitude", 1, 2, null);
		Question question1 = questionService.addQuestion(question);
		assertEquals(question.getQuestionTitle(), question1.getQuestionTitle());
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(0, new QuestionOptions("3", "1", "4", "7", null), "apptitude", 1, 2, null);
		Question question1 = questionService.addQuestion(question);
		question1.setQuestionTitle("softskills");
		Question question2 = questionService.updateQuestion(question1);
		assertEquals("softskills", question2.getQuestionTitle());
	}
	
}
