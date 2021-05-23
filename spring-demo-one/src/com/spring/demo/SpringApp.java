package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {

	// load spring config
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// retrieve bean
	Coach bean = context.getBean("trackCoach", Coach.class);

	// process
	System.out.println(bean.getDailyWorkout());

	System.out.println(bean.getDailyFortune());

	// test setter inject
	Coach cricketBean = context.getBean("cricketCoach", Coach.class);

	System.out.println(cricketBean.getDailyWorkout());
	System.out.println(cricketBean.getDailyFortune());

	// test literal values
	System.out.println(((CricketCoach) cricketBean).getEmailAddress());
	System.out.println(((CricketCoach) cricketBean).getTeam());

	// test properties values
	System.out.println(((CricketCoach) cricketBean).getStatus());
	System.out.println(((CricketCoach) cricketBean).getProgram());

	// Practice Activity #2
	Coach baseBall = context.getBean("baseBallCoach", Coach.class);
	System.out.println(baseBall.getDailyWorkout());
	System.out.println(baseBall.getDailyFortune());

	// close
	context.close();

    }

}
