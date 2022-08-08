package com.sportscoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationComtext-AnnotateExample.xml");
		Coach coach = context.getBean("mySecondCoach", Coach.class);
		System.out.println(coach.getWorkOut());
		System.out.println(coach.getTodaysFortune());
		
		
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("ApplicationComtext-AnnotateExample.xml");
		Coach coach2 = context.getBean("footBallCoach", Coach.class);
		System.out.println(coach2.getWorkOut());
		System.out.println(coach.getWorkOut());
		System.out.println(coach2.getTodaysFortune());
		
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("ApplicationComtext-AnnotateExample.xml");
		Coach coach3 = context3.getBean("tennisCoach", Coach.class);
		System.out.println(coach3.getWorkOut());
		System.out.println(coach3.getTodaysFortune());
		
		
		context.close();
		context2.close();
		context3.close();
	}

}
