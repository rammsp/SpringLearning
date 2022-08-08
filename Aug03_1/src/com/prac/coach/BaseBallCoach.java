package com.prac.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.prac.fortune.FortuneService;

@Component("myCoach")
public class BaseBallCoach implements Coach {

	@Autowired
	@Qualifier("goodFortune")
	FortuneService fortuneService;

	public BaseBallCoach() {
	}

	public BaseBallCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getCoach() {
		return "Practice Baseball!!!" + "\n" + fortuneService.getFortune();
	}

	
	@PostConstruct
	public void initial() { System.out.println("This is initial method!!"); }
	  
	@PreDestroy
	public void destroy() { System.out.println("This is destroy method!!"); }
	 

	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 * 
	 * 
	 * public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

}
