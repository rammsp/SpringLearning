package com.sportcoachwithdepinj;

public class BaseBallCoachOne implements CoachOne {
	
	private FortuneService fortuneService;

	public BaseBallCoachOne(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Practise Baseball for 2 Hours!!!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortuneForTheDay();
	}

}
