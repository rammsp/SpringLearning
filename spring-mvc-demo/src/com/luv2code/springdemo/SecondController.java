package com.luv2code.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home") // Creates a path defect for second looping to the page. 
//So avoided in those areas of looping back
public class SecondController {
	
	@RequestMapping("/enroll")
	public String showEnrollPageOne(HttpServletRequest request, Model model) {
		String qualification = request.getParameter("studentQualification");
		qualification = qualification.toUpperCase();
		model.addAttribute("studentQualification", qualification);
		return "enroll-result";
	}

	@RequestMapping("/enrollResultTwo")
	public String showEnrollPageTwo(@RequestParam("studentQualification") String qualification, Model model) {
		qualification = qualification.toUpperCase();
		model.addAttribute("studentQualification", qualification);
		return "enroll-result";
	}
	
	@RequestMapping("/")
	public String showMainMenuPage() {
		return "main-menu";
	}
	
	@RequestMapping("/studentForm")
	public String showStudentFormPage() {
		return "student-form";
	}

}
