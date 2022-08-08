package com.prac.fortune;

import org.springframework.stereotype.Component;

@Component
public class GoodFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Have a great day!!!";
	}

}
