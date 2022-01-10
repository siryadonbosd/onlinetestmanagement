package com.cg.onlinetestms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinetestms.dao.QuestionDao;
import com.cg.onlinetestms.dao.TestDao;
import com.cg.onlinetestms.entities.Test;

@Service
@Transactional
@Component
public class TestService {
	@Autowired
	TestDao testDao;
	@Autowired
	QuestionDao questionDao;

	public Test addTest(Test test) {
		return testDao.save(test);
	}

	public Test updateTest(Test test) {
		Optional<Test> op = testDao.findById(test.getTestId());
		Test updatedTest = op.get();
		updatedTest.update(test);
		return testDao.save(updatedTest);
	}

	public Test deleteTest(Test test) {
		Optional<Test> op = testDao.findById(test.getTestId());
		Test deleteTest = op.get();
		testDao.delete(test);
		return deleteTest;

	}

}
