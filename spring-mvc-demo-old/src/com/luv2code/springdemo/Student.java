package com.luv2code.springdemo;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	private String currentState;
	
	private String language;
	
	private LinkedHashMap<String, String> languageOptions;
	
	private String[] os;

	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("INDIA", "India");
		countryOptions.put("UAE", "United Arab Emirates");
		countryOptions.put("SIN", "Singapore");
		languageOptions = new LinkedHashMap<String, String>();
		languageOptions.put("EN", "English");
		languageOptions.put("TA", "Tamil");
		languageOptions.put("KA", "Kannada");
		languageOptions.put("ML", "Malayalam");
	}
	
	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}
	
	public String getCurrentState() {
		return currentState;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
