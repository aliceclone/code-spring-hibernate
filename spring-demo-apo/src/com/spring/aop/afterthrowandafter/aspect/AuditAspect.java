package com.spring.aop.afterthrowandafter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Pointcut("execution(public * com.spring.aop.afterthrowandafter..*.find* (..))")
    public void afterThrowPackage() {
    };

    @AfterThrowing(pointcut = "afterThrowPackage()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterThrowing()");
	// System.out.println("📍 " + joinPoint.getSignature().toShortString());

	System.out.println("📍Send to DevOps team: " + ex);
	// ex.printStackTrace();
    }

    // as SAME aspect class with afterThrowing(), will execute after exception
    @After("afterThrowPackage()")
    public void afterSameAspect() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterSameAspect()");

    }

}
