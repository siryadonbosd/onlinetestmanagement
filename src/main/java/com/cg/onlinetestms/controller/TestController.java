package com.cg.onlinetestms.controller;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetestms.entities.Test;
import com.cg.onlinetestms.service.TestService;

@RestController
@RequestMapping("/testcontroller")
@CrossOrigin(origins = "*")
@Validated
public class TestController {
	@Autowired
	TestService testService;

	private Logger logger=Logger.getLogger(TestController.class);
	
	@PostMapping("/addtest")
	public Test newTest(@RequestBody Test test) {
		logger.info("test added");
		return testService.addTest(test);
	}

	@PutMapping("/updatetest")
	public Test updateTest(@RequestBody Test test) {
		return testService.updateTest(test);
	}

	@DeleteMapping("/deletetest/{id}")
	public Test deleteTest(@RequestBody Test test) {
		return testService.deleteTest(test);
	}
	
}