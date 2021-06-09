package com.spring.aop.afterthrow.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Pointcut("execution(public * com.spring.aop.afterthrow..*.find* (..))")
    private void afterThrowPackage() {
    };

    @AfterThrowing(pointcut = "afterThrowPackage()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterThrowing()");
	// System.out.println("📍 " + joinPoint.getSignature().toShortString());

	System.out.println("📍Send to DevOps team: ");
	ex.printStackTrace();
    }

}
