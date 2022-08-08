package com.sportscoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootBallCoach implements Coach {
	
	FortuneService fortuneService;

	@Autowired
	@Qualifier("RANDFortune")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Practice FootBall for 5 Hours!!!";
	}

	@Override
	public String getTodaysFortune() {
		return fortuneService.getFortune();
	}

}
