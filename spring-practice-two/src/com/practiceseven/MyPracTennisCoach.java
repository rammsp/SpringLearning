package com.practiceseven;

import org.springframework.beans.factory.annotation.Value;

public class MyPracTennisCoach implements MyPracCoach {
	
	MyPracFortune myPracFortune;
	
	@Value("${prac.email}")
	public String email;

	public MyPracTennisCoach(MyPracFortune myPracFortune) {
		super();
		this.myPracFortune = myPracFortune;
	}


	@Override
	public String getWorkOut() {
		return "Practice Tennis for 2 Hours and send report to " + email;
	}

	@Override
	public String getFortune() {
		return myPracFortune.getTodaysFortune();
	}

}
