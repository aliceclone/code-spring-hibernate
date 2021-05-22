package com.spring.demo;

public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
	return "10 minutes walking advice by a baseball coach.";
    }
}
