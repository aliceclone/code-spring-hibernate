package com.spring.aop.afterreturn.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("execution(public * com.spring.aop.afterreturn..*.find* (..))")
    private void afterReturnPackage() {
    };

    @AfterReturning(pointcut = "afterReturnPackage()", returning = "returnType")
    public void afterReturningAllObject(JoinPoint jointPoint, Object returnType) {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterReturningAllObject()");
	System.out.println("📍📍 " + jointPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "afterReturnPackage()", returning = "returnType")
    public void afterReturningAccounts(JoinPoint jointPoint, List<Account> returnType) {
	System.out.println("📍 " + getClass().getSimpleName() + ": " + " afterReturningAccounts()");
	System.out.println("📍 📍" + jointPoint.getSignature().toShortString());

	convertToUpperCase(returnType);
    }

    private void convertToUpperCase(List<Account> returnType) {

	for (Account account : returnType) {
	    String upperCase = account.getLevel().toUpperCase();
	    account.setLevel(upperCase);
	}

    }

}
