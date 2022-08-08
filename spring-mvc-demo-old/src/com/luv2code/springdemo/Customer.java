package com.luv2code.springdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.constraints.CourseCode;

public class Customer {
	
	@NotNull(message = "Is Required")
	@Size(min = 2, message = "Is Required")
	private String firstName;
	
	private String lastName;
	
	@Min(value = 1, message="Please enter a value greater than Zero")
	@Max(value = 9, message = "Please enter a lesser than Ten")
	@NotNull(message = "Is Required")
	private Integer passes;
	
	@Pattern(regexp = "^[A-Z 0-9]{5}$", message = "Please enter the 5 Digits")
	private String postalCode;
	
	@CourseCode
	private String tutorial;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getPasses() {
		return passes;
	}

	public void setPasses(Integer passes) {
		this.passes = passes;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}


}
