package com.spring.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspectPointcutDeclare {

    // declare pointcut for dao package
    @Pointcut("execution(public * com.spring.demo.aop.dao.*.* (..))")
    private void anyMethodOfDao() {
	// will not run this part!
    }

    @Before("anyMethodOfDao()")
    public void beforeAnyMethodOfDao() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyMethodOfDao()");
    }
}
