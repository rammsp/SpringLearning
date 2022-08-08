package com.prac.coach;

import com.prac.fortune.FortuneService;

public class FootballCoach implements Coach {
	
	FortuneService fortuneService;


	public FootballCoach() {
	}


	public FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}


	@Override
	public String getCoach() {
		return "Practice Football!!! " + "\n" + fortuneService.getFortune();
	}

	
	public void initial() {
		System.out.println("This is initial method!!");
	}
	
	public void destroy() {
		System.out.println("This is destroy method!!");
	}

	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 * 
	 * 
	 * public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	

}
