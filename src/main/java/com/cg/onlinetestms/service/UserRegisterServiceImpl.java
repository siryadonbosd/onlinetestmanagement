package com.cg.onlinetestms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetestms.dao.UserRegistrationDao;
import com.cg.onlinetestms.dto.UserDetails;

import com.cg.onlinetestms.exception.UserNotFoundException;
@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {
@Autowired
	private UserRegistrationDao uDao;

	private Logger logger=Logger.getLogger(UserRegisterServiceImpl.class);
	@Override
	public UserDetails findByName(UserDetails userDetails) {
		Optional<UserDetails> opt = uDao.findById(userDetails.getUsername());
		if(!opt.isPresent() ) {
			logger.error("user with userName :" +userDetails.getUsername()+" not found");
			throw new UserNotFoundException("user with userName :" +userDetails.getUsername()+" not found" );
		}
		UserDetails details =opt.get();
		if(!details.getPassword().equals(userDetails.getPassword())) {
			throw new UserNotFoundException( "Invalid Credentials");
		}
		return details;
	}
	@Override
	public UserDetails register(UserDetails uDetails) {
		List<UserDetails> uList = uDao.findAll();
		for (UserDetails user : uList) {
			if(user.getUsername().equals(uDetails.getUsername())) {
				throw new UserNotFoundException( "userName : "+ uDetails.getUsername()+" Already Exsist");
			}
		}
		UserDetails details = uDao.save(uDetails);
		return details;
	}

}
