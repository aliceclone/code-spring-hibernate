package com.spring.aop.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.pointcut.dao.AccountDao;

public class MainPointcutDeclareApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	com.spring.aop.pointcut.dao.AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

	// @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
	accountDao.addAccount(new com.spring.entity.Account());

	// close
	context.close();

    }

}
