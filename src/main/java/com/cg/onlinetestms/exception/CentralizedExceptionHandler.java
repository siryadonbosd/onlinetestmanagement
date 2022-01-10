package com.cg.onlinetestms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(AdminNotFoundException.class)
	public String handleAdminNotFound(AdminNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(QuestionNotFoundException.class)
	public String handleQuestionNotFound(QuestionNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TestNotFoundException.class)
	public String handleTestNotFound(TestNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TestAlreadyExistsException.class)
	public String handleTestExists(TestAlreadyExistsException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception e) {
		
		return e.getMessage();
	}
	
}
