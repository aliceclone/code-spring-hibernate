package com.spring.aop.pointcut.dao;

import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Component
public class AccountDao {

    private int id;

    public int getId() {
	System.out.println(getClass().getSimpleName() + ": getId()");
	return id;
    }

    public void setId(int id) {
	System.out.println(getClass().getSimpleName() + ": setId()");
	this.id = id;
    }

    public void addAccount(Account account) {
	System.out.println(getClass().getSimpleName() + ": addAccount()");
	System.out.println("");
    }

}
