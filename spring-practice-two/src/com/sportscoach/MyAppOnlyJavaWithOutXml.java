package com.sportscoach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAppOnlyJavaWithOutXml {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
		Coach coach = context.getBean("mySecondCoach", Coach.class);
		
		System.out.println(coach.getWorkOut());
		System.out.println(coach.getTodaysFortune());
		
		context.close();
	}

}
