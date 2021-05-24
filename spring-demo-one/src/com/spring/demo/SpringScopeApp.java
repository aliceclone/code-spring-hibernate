package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeApp {

    public static void main(String[] args) {

	// load config
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scope-applicationContext.xml");

	// retrieve bean
	Coach coachAplha = context.getBean("trackCoach", Coach.class);
	Coach coachBeta = context.getBean("trackCoach", Coach.class);

	// test prototype scope
	System.out.println("[Result] Is same object: " + coachAplha.equals(coachBeta));
    }

}
