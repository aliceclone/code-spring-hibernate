package com.spring.aop.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MessageAspect {

    @Before("execution(public * com.spring.aop.pointcut.dao.*.* (..))")
    public void beforeAnyClassAnyMethod() {
	// any class of any method under specific package
	// & zero or more any package
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAnyClassAnyMethod()");
    }

}
