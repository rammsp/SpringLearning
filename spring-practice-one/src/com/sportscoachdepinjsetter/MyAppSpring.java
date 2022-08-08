package com.sportscoachdepinjsetter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppSpring {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContextDepInjSetter.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		
		System.out.println(coach.getWorkOut());
		
		System.out.println(coach.getFortune());
		
		System.out.println(coach.getTeamName());
		
		System.out.println(coach.getEmailAddress());
		
		context.close();
		
	}

}
