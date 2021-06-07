package com.spring.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.aop.dao.AccountDao;
import com.spring.demo.aop.dao.OtherAccountDao;
import com.spring.demo.aop.entity.Account;

public class MainApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
	OtherAccountDao otherAccount = context.getBean("otherAccountDao", OtherAccountDao.class);

	// logic

	// intercept match :
	// @Before("execution(public void addAccount(com.spring.demo.aop..*, ..))")
	// @Before("execution(public * com.spring.demo.aop.dao.*.* (..))")
	// @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
	accountDao.addAccount(new Account());

	// intercept match :
	// @Before("execution(public * com.spring.demo.aop.dao.*.* (..))")
	// @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
	otherAccount.addAccount();

	// intercept match:
	// @Before("execution(public * com.spring.demo.aop.dao.*.* (..))")
	// @Before("execution(* update* ())")
	// @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
	otherAccount.updateSomething();

	// close
	context.close();

    }

}
