package com.spring.demo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeAnnotationApp {

    public static void main(String[] args) {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	Coach swimCoachA = context.getBean("swimmingCoach", Coach.class);
	Coach swimCoachB = context.getBean("swimmingCoach", Coach.class);
	System.out.println("[Result] is same in prototype scope: " + swimCoachA.equals(swimCoachB));

    }

}
