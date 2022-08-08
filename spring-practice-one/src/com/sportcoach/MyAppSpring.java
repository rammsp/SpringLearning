package com.sportcoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppSpring {

	public static void main(String[] args) {

		//Create a new container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Retrieve bean from the container
		Coach coach = context.getBean("myCoach", Coach.class);

		System.out.println(coach.getDailyWorkOut());

		context.close();

	}

}
