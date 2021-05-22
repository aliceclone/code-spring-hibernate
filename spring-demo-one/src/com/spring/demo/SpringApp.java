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

	// close
	context.close();

    }

}
