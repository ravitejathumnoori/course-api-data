package com.course.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		
		System.out.println("Main method started");
		SpringApplication.run(CourseApiApp.class, args);
	}

}
