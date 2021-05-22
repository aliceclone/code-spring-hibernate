package com.spring.demo;

public class TrackCoach implements Coach {

    public TrackCoach() {
    }

    // inject
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Run like a hell workout by a track coach.";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
