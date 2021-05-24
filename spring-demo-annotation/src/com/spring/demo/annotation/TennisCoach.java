package com.spring.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
@Component
public class TennisCoach implements Coach {

    // inject
    // field inject
    @Autowired
    private FortuneService fortuneService;

    public TennisCoach() {
    }

    // mark dependency, search qualifying bean of type
    // spring 4.3 and later, optional when ONLY one constructor exist

    /*
     * @Autowired public TennisCoach(FortuneService fortuneService) {
     * this.fortuneService = fortuneService; }
     */

    @Override
    public String getDailyWorkout() {
	return "Practice makes perfect!";
    }

    public String getFortune() {
	return fortuneService.getFortune();

    }

}
