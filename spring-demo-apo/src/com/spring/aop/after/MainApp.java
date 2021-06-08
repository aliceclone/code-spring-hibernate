package com.spring.aop.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.after.dao.AccountDao;
import com.spring.aop.after.dao.OtherAccountDao;
import com.spring.entity.Account;

public class MainApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	AccountDao accountDao = context.getBean("accDao", AccountDao.class);
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
