package com.sportbeanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeacnScope-ApplicationContext.xml");
		
		CoachService coachOne = context.getBean("myCoach", CoachService.class);
		
		CoachService coachTwo = context.getBean("myCoach", CoachService.class);
		
		System.out.println(coachOne == coachTwo);
		
		System.out.println(coachOne.equals(coachTwo));
		
		System.out.println(coachOne);
		
		System.out.println(coachTwo);
		
		context.close();

	}

}
