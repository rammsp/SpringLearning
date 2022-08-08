package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showMainMenuPage() {
		return "main-menu";
	}
	
	@RequestMapping("/studentForm")
	public String showStudentFormPage() {
		return "student-form";
	}

}
