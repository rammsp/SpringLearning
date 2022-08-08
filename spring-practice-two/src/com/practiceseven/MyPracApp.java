package com.practiceseven;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyPracApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyPracSpringConfig.class);
		MyPracCoach coach = context.getBean("myCoach", MyPracCoach.class);
		
		System.out.println(coach.getWorkOut());
		System.out.println(coach.getFortune());
		
		context.close();
	}

}
