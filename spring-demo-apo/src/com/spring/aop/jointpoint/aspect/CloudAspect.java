package com.spring.aop.jointpoint.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Aspect
@Component
public class CloudAspect {

    @Pointcut("execution(* com.spring.aop.jointpoint..*.* (..))")
    private void jointpointPackage() {
    }

    @Before("jointpointPackage()")
    public void beforeAdvice(JoinPoint jointPoint) {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " beforeAdvice()");
	// get signature
	MethodSignature signature = (MethodSignature) jointPoint.getSignature();
	System.out.println("📍 Signature: \n" + signature);

	// get args
	Object[] args = jointPoint.getArgs();

	for (Object temp : args) {
	    System.out.println("📍 : " + temp);

	    if (temp instanceof com.spring.entity.Account) {
		Account account = (com.spring.entity.Account) temp;
		System.out.println(account.getLevel());
	    }
	    // autobox for int
	    if (temp instanceof Integer) {
		System.out.println("I'm Integer: " + temp);
	    }
	}

    }

}
