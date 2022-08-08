package com.springrest.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.exceptionentity.GenericExceptionResponse;
import com.spring.demo.exceptionentity.StudentNotFoundException;
import com.spring.demo.exceptionentity.StudentNotFoundResponse;

@ControllerAdvice
public class GlobalEceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentNotFoundResponse> handleStudentNotFoundException(StudentNotFoundException exc) {
		StudentNotFoundResponse errorResponse = new StudentNotFoundResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<GenericExceptionResponse> handleGenericException(Exception exc) {
		GenericExceptionResponse errorResponse = new GenericExceptionResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
