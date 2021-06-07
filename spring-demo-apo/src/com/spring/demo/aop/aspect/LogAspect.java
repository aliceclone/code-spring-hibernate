package com.spring.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // ONLY FOR SPECIFIC class & parameter
    // @Before("execution(public void
    // com.spring.demo.aop.dao.AccountDao.addAccount(com.spring.demo.aop.Account))")

    // ❗️Error: fully qualifier Type is required for parameter
    // @Before("execution(public void addAccount(Account)")
    @Before("execution(public void addAccount(com.spring.demo.aop..*, ..))")
    public void beforeAnyAddAcountWithArg() {
	// any class of addAcctount() & 1st parameter type under specific package
	// & 2nd parameter zero or more any package
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyAddAcountWithArg()");
    }

    @Before("execution(public * com.spring.demo.aop.dao.*.* (..))")
    public void beforeAnyClassAnyMethod() {
	// any class of any method under specific package
	// & zero or more any package
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyClassAnyMethod()");
    }

    // modifier optional, return any type
    @Before("execution(* update* ())")
    public void beforeAnyUpdateMethodOfAnyClass() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyUpdateMethodOfAnyClass()");
    }

}
