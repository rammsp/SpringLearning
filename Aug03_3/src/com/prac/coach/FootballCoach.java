package com.prac.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.prac.fortune.FortuneService;

@Component
public class FootballCoach implements Coach {
	
	@Autowired
	@Qualifier("badFortune")
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


	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 * 
	 * 
	 * public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	
	

}
