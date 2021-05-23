package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {

	// load spring config
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// retrieve bean
	Coach bean = context.getBean("coach", Coach.class);

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

	// close
	context.close();

    }

}
