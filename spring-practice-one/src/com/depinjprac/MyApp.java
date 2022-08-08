package com.depinjprac;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContextDepInjPractise.xml");
		CoachService coachService = context.getBean("myCoach", CoachService.class);
		for (int i = 0; i < 20; i++) {
			System.out.println(coachService.getWorkout());
		}
		
		context.close();
	}

}
