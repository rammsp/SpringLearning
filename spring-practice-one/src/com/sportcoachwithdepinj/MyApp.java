package com.sportcoachwithdepinj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextOne.xml");
		
		CoachOne coach = applicationContext.getBean("myCoachOne", CoachOne.class);
		
		System.out.println(coach.getWorkOut());
		
		System.out.println(coach.getFortune());
		
		applicationContext.close();

	}

}
