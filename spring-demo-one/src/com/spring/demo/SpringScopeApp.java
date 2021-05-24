package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeApp {

    public static void main(String[] args) {

	// load config
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scope-applicationContext.xml",
		"scope-hook-applicationContext.xml");
	// ant style result same as above
	// new ClassPathXmlApplicationContext("scope-*Context.xml");

	// retrieve bean from scope-applicationContext.xml
	Coach coachAplha = context.getBean("trackCoach", Coach.class);
	Coach coachBeta = context.getBean("trackCoach", Coach.class);

	// test prototype scope
	System.out.println("[Result] Is same object: " + coachAplha.equals(coachBeta));

	// retrieve bean from scope-hook-applicationContext.xml
	// test init-method and destory-method
	// [Note] In the case of prototypes, configured destruction lifecycle callbacks
	// are not called.
	Coach baseBallCoach = context.getBean("baseballCoach", Coach.class);
	System.out.println("[getDailyFortune]: " + baseBallCoach.getDailyFortune());

	context.close();
    }

}
