package com.prac.fortune;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoodFortune implements FortuneService {
	
	@Value("${email}")
	private String email;

	@Override
	public String getFortune() {
		return "Have a great day!!!" + email;
	}

}
