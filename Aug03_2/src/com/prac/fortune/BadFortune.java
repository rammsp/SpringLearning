package com.prac.fortune;

import org.springframework.stereotype.Component;

@Component
public class BadFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Sorry for the Bad Day!!!";
	}

}
