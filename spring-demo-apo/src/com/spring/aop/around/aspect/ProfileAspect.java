package com.spring.aop.around.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileAspect {

    private static final Logger LOGGER = Logger.getLogger(ProfileAspect.class.getName());

    @Pointcut("execution(public * com.spring.aop.around.service.*.* (..))")
    public void aroundPackage() {
    };

    @Around("aroundPackage()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	// start
	long start = System.currentTimeMillis();
	LOGGER.info("📍 " + getClass().getSimpleName() + ": " + " around() Start");
	Object obj = null;
	try {
	    // ❗execute target method️
	    obj = proceedingJoinPoint.proceed();
	} catch (Exception e) {
	    LOGGER.warning("📍 " + getClass().getSimpleName() + ":  " + e.getMessage());
	    obj = "UnExpected exception is occured.";

	    // rethrow
	    throw e;
	}

	LOGGER.info("📍 " + getClass().getSimpleName() + ": " + " around() End");

	// end
	long end = System.currentTimeMillis();

	// calculate
	LOGGER.info("📍 Duriation : " + (end - start) / 1000.0);

	return obj;
    }

    @AfterThrowing(pointcut = "aroundPackage()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
	LOGGER.warning("📍 " + getClass().getSimpleName() + ": " + " afterThrowing()");
	LOGGER.warning("📍Send to DevOps team: " + ex);
    }

}
