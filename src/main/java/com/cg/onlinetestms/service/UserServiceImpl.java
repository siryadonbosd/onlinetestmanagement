package com.cg.onlinetestms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetestms.dao.TestDao;
import com.cg.onlinetestms.dao.UserDao;
import com.cg.onlinetestms.entities.Test;
import com.cg.onlinetestms.entities.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao uDao;
	@Autowired
	private TestDao testDao;

	public User assignTest(int userId, int testId) {
		User auser = uDao.findByUserId(userId);
		Optional<Test> op = testDao.findById(testId);
		Test atest = op.get();
		auser.setUserTest(atest);
		return uDao.save(auser);
		//return null; //  
	}

}
