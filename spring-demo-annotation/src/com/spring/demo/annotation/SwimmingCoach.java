package com.spring.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    private FortuneService happyFortuneService;

    // optional default constructor for spring 5
    public SwimmingCoach() {
    }

    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
	this.happyFortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Swim 30 minutes a day.";
    }

    @Override
    public String getFortune() {
	return "[SwimmingCoach] " + happyFortuneService.getFortune();
    }

}
