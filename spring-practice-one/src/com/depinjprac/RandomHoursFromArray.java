package com.depinjprac;

public class RandomHoursFromArray implements RandomHoursService {

	@Override
	public int getRandomHours() {
		int workOutHours[] = new int[]{1, 10, 20, 30, 40, 50};
		return workOutHours [(int)(Math.random() * workOutHours.length + 0)];
	}

}
