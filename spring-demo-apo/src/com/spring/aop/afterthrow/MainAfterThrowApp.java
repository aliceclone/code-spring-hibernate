package com.spring.aop.afterthrow;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.afterthrow.dao.CoachDao;
import com.spring.entity.Account;

public class MainAfterThrowApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	CoachDao coachDao = context.getBean("coachDao", CoachDao.class);

	// logic

	try {

	    // true to trigger exception
	    List<Account> coaches = coachDao.findCoaches(true);
	    System.out.println(coaches);

	} catch (Exception e) {
	    // e.printStackTrace();
	}

	// close
	context.close();

    }

}
