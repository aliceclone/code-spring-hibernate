package com.spring.aop.around;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.around.service.CakeService;

public class MainAroundApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	CakeService cakeService = context.getBean("cakeService", CakeService.class);

	// logic

	String serviceText = "";

	try {
	    serviceText = cakeService.bakeCake(true);
	} catch (Exception e) {
	    // e.printStackTrace();
	    System.out.println("MainAroundApp : Oh No!");
	}

	System.out.println("MainAroundApp : " + serviceText);

	// close
	context.close();

    }

}
