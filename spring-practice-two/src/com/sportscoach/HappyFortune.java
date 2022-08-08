package com.sportscoach;

import org.springframework.stereotype.Component;

@Component("defaultFortune")
public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a great day!!!";
	}

}
