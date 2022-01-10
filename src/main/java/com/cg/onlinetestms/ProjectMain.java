package com.cg.onlinetestms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

@SpringBootApplication // convenience annotation
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
	public class ProjectMain {

		public static void main(String[] args) {
			SpringApplication.run(ProjectMain.class, args);
			System.out.println("server running");
		}

	}

