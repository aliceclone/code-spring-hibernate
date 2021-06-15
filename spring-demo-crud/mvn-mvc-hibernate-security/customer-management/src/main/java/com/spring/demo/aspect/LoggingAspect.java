package com.spring.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // get log
    private Logger log = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.spring.demo.controller..*.* (..))")
    private void controllerPackage() {
    }

    @Pointcut("execution(* com.spring.demo.dao..*.* (..))")
    private void daoPackage() {
    }

    @Pointcut("execution(* com.spring.demo.service..*.* (..))")
    private void servicePackage() {
    }

    @Pointcut("controllerPackage() || daoPackage() || servicePackage()")
    private void logPackages() {
    }

    @Before("logPackages()")
    public void before(JoinPoint joinPoint) {
	log.info("📍 :" + joinPoint.getSignature().toLongString() + ": before");
	for (Object arg : joinPoint.getArgs()) {
	    log.info("📍📍 arg:" + arg);
	}
    }

    @AfterReturning(pointcut = "logPackages()", returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
	log.info("📍 :" + joinPoint.getSignature().toLongString() + ": afterReturning");
	log.info("📍📍 returning:" + obj);

    }

}
