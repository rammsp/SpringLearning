package com.luv2code.springdemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Value("#{states}")
	private Map<String, String> statesMap;
	
	@RequestMapping("/studentEnrollmentForm")
	public String showStudentEnrollmentForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("states", statesMap);
		return "student-enroll-form";
	}
	
	@RequestMapping("/enrollmentSuccess")
	public String showEnrollmentSuccess(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstName() + student.getLastName());
		return "enrollment-success";
	}

}
