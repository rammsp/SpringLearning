package com.sportscoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppScopeTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contextOne = new ClassPathXmlApplicationContext("ApplicationComtext-AnnotateExample.xml");
		Coach coachOne = contextOne.getBean("mySecondCoach", Coach.class);
		Coach coachTwo = contextOne.getBean("mySecondCoach", Coach.class);
		
		ClassPathXmlApplicationContext contextTwo = new ClassPathXmlApplicationContext("ApplicationComtext-AnnotateExample.xml");
		Coach coachThree = contextTwo.getBean("footBallCoach", Coach.class);
		Coach coachFour = contextTwo.getBean("footBallCoach", Coach.class);
		
		System.out.println("BaseBall Object1: " + coachOne);
		System.out.println("BaseBall Object2: " + coachTwo);
		System.out.println("FootBall Object1: " + coachThree);
		System.out.println("FootBall Object2: " + coachFour);
		
		contextOne.close();
		contextTwo.close();

	}

}
