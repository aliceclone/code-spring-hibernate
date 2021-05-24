package com.spring.demo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
	// load config file
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// get bean
	Coach tennisBean = context.getBean("tennisCoach", Coach.class);
	System.out.println(tennisBean.getDailyWorkout());

	// practice Activity #4 - Inversion of Control with Java Annotations
	Coach swimmingBean = context.getBean("swimmingCoach", Coach.class);
	System.out.println(swimmingBean.getDailyWorkout());

	// test setter inject annotation
	// allow any field and setter method name unlike XML
	System.out.println(swimmingBean.getFortune());

	// constructor inject annotation
	System.out.println(tennisBean.getFortune());

	// close
	context.close();

    }

}
