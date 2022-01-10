package com.cg.onlinetestms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetestms.dto.UserDetails;

import com.cg.onlinetestms.entities.User;
import com.cg.onlinetestms.service.TestService;
import com.cg.onlinetestms.service.UserRegisterService;
import com.cg.onlinetestms.service.UserService;
import com.cg.onlinetestms.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
@Validated // to validate the parameter that are passed into a method
public class UserController {
	@Autowired
	TestService testService;
	@Autowired
	UserService userService;
	@Autowired
	private UserServiceImpl uService;
@Autowired
	private UserRegisterService cRegister;


@ResponseStatus(HttpStatus.ACCEPTED)
@PostMapping("/login/register")
public String register(@RequestBody UserDetails userDetails, HttpServletRequest request) {
	UserDetails uDetails = new UserDetails(userDetails.getUsername(), userDetails.getPassword(), "User");
	uDetails = cRegister.register(uDetails);
	return "Registration successful with Username : " + uDetails.getUsername() + " Role-> "
	+ uDetails.getUserRole();
}
	@PutMapping("/assignTest/{userId}/{testId}")
	// UserService userService = new UserServiceImpl(); instead of doing that...
	public User assignTest(@PathVariable int userId, @PathVariable int testId) {
		return uService.assignTest(userId, testId);
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login")
	public String login(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDetails uDetails = cRegister.findByName(userDetails);
		session.setAttribute("username", uDetails.getUsername());
		session.setAttribute("role", uDetails.getUserRole());
		
		return "Login Successful.......Welcome " + uDetails.getUsername() + " ->" + uDetails.getUserRole();
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (userDetails.getUsername().equals(session.getAttribute("username"))) {
			session.invalidate();
			return "You have successfully logged out " + userDetails.getUsername();
		}
		return "Not logged off";
	}

	
	
}
