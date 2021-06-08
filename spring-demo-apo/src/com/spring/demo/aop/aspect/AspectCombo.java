package com.spring.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AspectCombo {

    // pointcut for service package
    @Pointcut("execution(* com.spring.demo.aop.service.*.* (..))")
    private void servicePackage() {
    }

    // pointcut for setter
    @Pointcut("execution(public void set* (*))")
    private void setter() {
    }

    // pointcut for getter
    @Pointcut("execution(public * get* ())")
    private void getter() {
    }

    // exclude setter & getter for service package
    @Pointcut("servicePackage() && !(getter() || setter() )")
    private void excludeGetterSetter() {
    }

    @Before("excludeGetterSetter()")
    public void beforeExcludeGetterSetter() {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeExcludeGetterSetter()");
    }
}
