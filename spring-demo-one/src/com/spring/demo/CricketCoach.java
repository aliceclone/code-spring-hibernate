package com.spring.demo;

/**
 * example for setter injection
 *
 */
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    // need to create explicitly default constructor in Spring 4
    public CricketCoach() {
	System.out.println("CricketCoach");
    };

    public void setFortuneService(FortuneService fortuneService) {
	System.out.println("CricketCoach - setter method");
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Bowling for 10 minutes advice by CricketCoach.";
    }

    @Override
    public String getDailyFortune() {
	return fortuneService.getFortune();
    }

}
