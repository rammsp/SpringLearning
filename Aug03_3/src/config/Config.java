package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prac.coach.BaseBallCoach;
import com.prac.coach.Coach;
import com.prac.coach.FootballCoach;
import com.prac.fortune.BadFortune;
import com.prac.fortune.FortuneService;
import com.prac.fortune.GoodFortune;

@Configuration
public class Config {
	
	@Bean
	public Coach baseBallCoach() {
		Coach coach = new BaseBallCoach();
		return coach;
	}

	@Bean
	public Coach footballCoach() {
		Coach coach = new FootballCoach();
		return coach;
	}
	
	@Bean
	public FortuneService goodFortune() {
		FortuneService fortuneService = new GoodFortune();
		return fortuneService;
	}
	
	@Bean
	public FortuneService badFortune() {
		FortuneService fortuneService = new BadFortune();
		return fortuneService;
	}
	
}
