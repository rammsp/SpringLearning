package com.sportscoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("pleasantFortune")
	FortuneService fortuneService;

	@Override
	public String getWorkOut() {
		return "Practice Tennis for 5 Hours";
	}

	@Override
	public String getTodaysFortune() {
		return fortuneService.getFortune();
	}

}
