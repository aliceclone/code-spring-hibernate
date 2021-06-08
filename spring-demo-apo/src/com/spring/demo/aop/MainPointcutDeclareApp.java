package com.spring.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.demo.aop.dao.AccountDao;
import com.spring.demo.aop.entity.Account;

public class MainPointcutDeclareApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

	// @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
	accountDao.addAccount(new Account());

	// close
	context.close();

    }

}
