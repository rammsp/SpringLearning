package com.springrest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.exceptionentity.GenericExceptionResponse;
import com.spring.demo.exceptionentity.StudentNotFoundException;
import com.spring.demo.exceptionentity.StudentNotFoundResponse;
import com.springrest.demo.enitity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Rama", "Moorthy"));
		students.add(new Student("Rahim", "Khan"));
		students.add(new Student("Rex", "John"));
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Rama", "Moorthy"));
		students.add(new Student("Rahim", "Khan"));
		students.add(new Student("Rex", "John"));
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found: " + studentId);
		}
		return students.get(studentId);
	}
	
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
