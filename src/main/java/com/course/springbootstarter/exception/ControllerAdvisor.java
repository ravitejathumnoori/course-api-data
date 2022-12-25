package com.course.springbootstarter.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	
	
	public ControllerAdvisor() {
		super();
		System.out.println("From Advicer method");
	}

	@ExceptionHandler(value = {CourseNotFoundException.class})
	public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex, WebRequest request)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Course not found");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
