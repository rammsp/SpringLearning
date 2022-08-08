package com.sportbeanscope;

public class BaseBallCoach implements CoachService {
	
	FortuneService fortuneService;

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Practice Baseball for 3 Hours!!!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getTodaysFortune();
	}
	
	public void startUp() {
		System.out.println("Start-Up Method is called");
	}

	public void tearDown() {
		System.out.println("Tear-Down Method is called");
	}

}
