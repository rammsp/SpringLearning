package com.prac.coach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Coach coach = context.getBean("baseBallCoach", Coach.class);
		System.out.println(coach.getCoach());
		Coach coach1 = context.getBean("baseBallCoach", Coach.class);
		System.out.println(coach1.getCoach());
		context.close();

	}

}
