package com.sportscoachdepinjsetter;

public class BaseBallCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String teamName;
	
	public BaseBallCoach() {
		super();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String getWorkOut() {
		return "Practise BaseBall for 2 Hours!!!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getTodaysFortune();		
	}

}
