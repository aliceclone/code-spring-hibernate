package com.spring.aop.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.after.dao.OtherAccountDao;
import com.spring.aop.after.service.AccountService;
import com.spring.entity.Account;

public class MainExpressionComboApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	com.spring.aop.after.service.AccountService accountService = context.getBean("accountService",
		AccountService.class);
	accountService.combo(new Account());

	// check setter/getter is called
	// @Pointcut("servicePackage() && !(getter() || setter() )")
	accountService.setLevel("some level");
	accountService.setAccountDao(new OtherAccountDao());
	accountService.getLevel();

	// close
	context.close();

    }

}
