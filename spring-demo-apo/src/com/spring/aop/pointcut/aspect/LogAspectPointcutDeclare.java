package com.spring.aop.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LogAspectPointcutDeclare {

    // declare pointcut for dao package
    @Pointcut("execution(public * com.spring.aop.pointcut.dao.*.* (..))")
    private void anyMethodOfDao() {
	// will not run this part!
    }

    @Before("anyMethodOfDao()")
    public void beforeAnyMethodOfDao() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyMethodOfDao()");
    }
}
