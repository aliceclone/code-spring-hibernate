package com.spring.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
@Component
public class TennisCoach implements Coach {

    // inject
    private FortuneService fortuneService;

    // mark dependency, search qualifying bean of type
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Practice makes perfect!";
    }

    public String getFortune() {
	return fortuneService.getFortune();

    }

}
