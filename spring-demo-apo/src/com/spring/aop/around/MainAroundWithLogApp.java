package com.spring.aop.around;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.around.service.CakeService;

public class MainAroundWithLogApp {

    // log
    private static final Logger LOGGER = Logger.getLogger(MainAroundWithLogApp.class.getName());

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
	    LOGGER.warning("MainAroundApp : Oh No!");
	}

	LOGGER.info("MainAroundApp : " + serviceText);

	// close
	context.close();

    }

}
