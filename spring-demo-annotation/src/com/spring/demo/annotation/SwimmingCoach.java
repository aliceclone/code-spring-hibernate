package com.spring.demo.annotation;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    @Override
    public String getDailyWorkout() {
	return "Swim 30 minutes a day.";
    }

}
