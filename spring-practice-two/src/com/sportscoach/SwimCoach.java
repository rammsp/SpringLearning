package com.sportscoach;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	public FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Swin 1000 Meters per Day!!! as per " + email + " from " + team;
	}

	@Override
	public String getTodaysFortune() {
		return fortuneService.getFortune();
	}

}
