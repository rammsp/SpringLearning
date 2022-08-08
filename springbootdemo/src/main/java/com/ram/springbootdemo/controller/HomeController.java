package com.ram.springbootdemo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${first.name}")
	private String firstName;
	
	@Value("${last.name}")
	private String lastName;
	
	@GetMapping ("/")
	public String sayHello() {
		return "Hello World yeah !! The time on server is: " + LocalDateTime.now() + ". Stay cool " + firstName + " " + lastName;
	}

}
