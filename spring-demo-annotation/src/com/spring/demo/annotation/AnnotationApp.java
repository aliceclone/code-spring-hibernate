package com.spring.demo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
	// load config file
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	// get bean
	Coach bean = context.getBean("tennisCoach", Coach.class);
	System.out.println(bean.getDailyWorkout());

	// close
	context.close();

    }

}
