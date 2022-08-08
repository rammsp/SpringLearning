package com.sportcoachwithdepinj;

public class FootBallCoachOne implements CoachOne {
	
	
	private FortuneService fortuneService;

	public FootBallCoachOne(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Practise Football for 2 Hours!!!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortuneForTheDay();
	}

}
