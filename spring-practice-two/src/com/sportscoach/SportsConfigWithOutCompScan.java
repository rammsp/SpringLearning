package com.sportscoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sportsNoXml.properties")
public class SportsConfigWithOutCompScan {
	
	@Bean
	public FortuneService mySadFortuneService() {
		return new SadFortune();
	}

	@Bean
	public Coach mySwinCoach() {
		Coach coach = new SwimCoach(mySadFortuneService());
		return coach;
	}
	
}
