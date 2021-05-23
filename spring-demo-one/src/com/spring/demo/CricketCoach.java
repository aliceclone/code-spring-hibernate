package com.spring.demo;

/**
 * example for setter injection
 *
 */
public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String emailAddress;
    private String team;

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	System.out.println("setEmailAddress: " + emailAddress);
	this.emailAddress = emailAddress;
    }

    public String getTeam() {
	return team;
    }

    public void setTeam(String team) {
	System.out.println("setTeam: " + team);
	this.team = team;
    }

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
