package com.depinjprac;

public class FootBallCoach implements CoachService {
	
	private RandomHoursService randomHoursService;
	
	public FootBallCoach() {
		super();
	}

	public FootBallCoach(RandomHoursService randomHoursService) {
		super();
		this.randomHoursService = randomHoursService;
	}

	@Override
	public String getWorkout() {
		return "Practise Foot Ball for " + randomHoursService.getRandomHours() + " Hours!!!";
	}

}
