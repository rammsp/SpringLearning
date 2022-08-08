package com.sportscoach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component("mySecondCoach")
@Scope("singleton")
public class BaseBallCoach implements Coach {
	
	FortuneService fortuneService;

	@Autowired
	public BaseBallCoach(@Qualifier("defaultFortune")FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getWorkOut() {
		return "Practice BaseBall for 5 Hours!!!";
	}

	@Override
	public String getTodaysFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Start-Up Stuff");
	}

	@PreDestroy
	public void doMyTearDownStuff() {
		System.out.println("Tear-Down Stuff");
	}
	
}
