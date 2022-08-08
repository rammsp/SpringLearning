package com.sportcoach;

public class MyApp {

	public static void main(String[] args) {

		Coach coach1 = new BaseBallCoach();
		System.out.println(coach1.getDailyWorkOut());
		
		Coach coach2 = new TrackCoach();
		System.out.println(coach2.getDailyWorkOut());

	}

}
