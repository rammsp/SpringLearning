package com.spring.demo.exceptionentity;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

}
