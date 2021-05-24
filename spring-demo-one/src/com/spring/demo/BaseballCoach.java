package com.spring.demo;

public class BaseballCoach implements Coach {

    // inject
    private FortuneService fortuneService;

    public BaseballCoach() {
	System.out.println("[BaseballCoach - default constructor]");
    }

    // define constructor injection
    public BaseballCoach(FortuneService fortuneService) {
	System.out.println("[BaseballCoach - arg constructor]");
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

    public void doReady() {
	System.out.println("[BaseballCoach - doReady]");
    }

    public void doCleanup() {
	System.out.println("[BaseballCoach - doCleanup]");
    }
}
