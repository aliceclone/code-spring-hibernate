package com.spring.demo.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("myTennisCoach")
@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
    }

    // mark dependency, search qualifying bean of type
    // spring 4.3 and later, optional when ONLY one constructor exist
    // multi implementation, use qualifier
    @Autowired
    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Practice makes perfect!";
    }

    public String getFortune() {
	return fortuneService.getFortune();

    }

    @PostConstruct
    public void doSomething() {
	System.out.println("[TennisCoach] do something.");
    }

    @PreDestroy
    public void cleanMess() {
	System.out.println("[TennisCoach] clean mess.");

    }

}
