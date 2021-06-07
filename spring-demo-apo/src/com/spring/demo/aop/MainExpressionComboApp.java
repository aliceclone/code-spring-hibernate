package com.spring.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.aop.dao.AccountDao;
import com.spring.demo.aop.entity.Account;
import com.spring.demo.aop.service.AccountService;

public class MainExpressionComboApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	AccountService accountService = context.getBean("accountService", AccountService.class);
	accountService.combo(new Account());

	// check setter/getter is called
	// @Pointcut("servicePackage() && !(getter() || setter() )")
	accountService.setLevel("some level");
	accountService.setAccountDao(new AccountDao());
	accountService.getLevel();

	// close
	context.close();

    }

}
