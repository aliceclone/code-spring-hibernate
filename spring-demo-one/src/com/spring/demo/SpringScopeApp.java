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
	Coach baseBallCoach = context.getBean("baseballCoach", Coach.class);
	System.out.println("[getDailyFortune]: " + baseBallCoach.getDailyFortune());

	// Practice Activity #3 Bean Scopes
	// [Note] prototype scope configured destruction lifecycle callbacks
	// are not called.

	ClassPathXmlApplicationContext activityContext = new ClassPathXmlApplicationContext(
		"scope-hook-activity-applicationContext.xml");
	Coach footballCoachA = activityContext.getBean("footballCoach", Coach.class);
	Coach footballCoachB = activityContext.getBean("footballCoach", Coach.class);
	// test bean life and scope
	System.out.println(
		"[Result] footballCoachA == footballCoachB in prototype: " + footballCoachA.equals(footballCoachB));

	// close
	context.close();
	activityContext.close();
    }

}
