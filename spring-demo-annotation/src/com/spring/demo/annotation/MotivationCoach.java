package com.spring.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MotivationCoach implements Coach {

    // field inject
    @Autowired
    @Qualifier("quotesFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
	return "[MotivationCoach] Listen music daily.";
    }

    @Override
    public String getFortune() {
	return fortuneService.getFortune();
    }

}
