package com.sportscoach;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PleasantFortune implements FortuneService {
	
	@Value("${prop.email}")
	public String email;

	@Override
	public String getFortune() {
		return "Today is a Pleasant Day!!! " + email ;
	}

}
