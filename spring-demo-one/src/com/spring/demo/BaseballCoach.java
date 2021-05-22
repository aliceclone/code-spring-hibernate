package com.spring.demo;

public class BaseballCoach implements Coach {

    // inject
    private FortuneService fortuneService;

    public BaseballCoach() {
    }

    // define constructor injection
    public BaseballCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "10 minutes walking advice by a baseball coach.";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
