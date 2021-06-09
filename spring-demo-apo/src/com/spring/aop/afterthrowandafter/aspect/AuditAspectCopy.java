package com.spring.aop.afterthrowandafter.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspectCopy {

    // as DIFFERENT aspect class with afterThrowing(), will execute BEFORE exception
    @After("com.spring.aop.afterthrowandafter.aspect.AuditAspect.afterThrowPackage()")
    public void afterDifferentAspect() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterDifferentAspect()");

    }

}
