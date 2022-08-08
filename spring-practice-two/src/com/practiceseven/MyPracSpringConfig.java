package com.practiceseven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:MyPrac7.properties")
public class MyPracSpringConfig {
	
	@Bean
	public MyPracFortune myFortune() {
		return new MyPracGoodFortune();
	}
	
	@Bean
	public MyPracCoach myCoach() {
		MyPracCoach myPracCoach = new MyPracTennisCoach(myFortune());
		return myPracCoach;
	}

}
