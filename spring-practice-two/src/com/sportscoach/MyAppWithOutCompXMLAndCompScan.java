package com.sportscoach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAppWithOutCompXMLAndCompScan {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfigWithOutCompScan.class);
		Coach coach  = context.getBean("mySwinCoach", Coach.class);
		
		System.out.println(coach.getWorkOut());
		System.out.println(coach.getTodaysFortune());
		
		context.close();

	}

}
