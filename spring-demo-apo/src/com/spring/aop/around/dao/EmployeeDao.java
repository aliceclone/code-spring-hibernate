package com.spring.aop.around.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Component
public class EmployeeDao {

    private int id;

    public int getId() {
	System.out.println(getClass().getSimpleName() + ": getId()");
	return id;
    }

    public void setId(int id) {
	System.out.println(getClass().getSimpleName() + ": setId()");
	this.id = id;
    }

    public Account findCoach(int id) {
	System.out.println(getClass().getSimpleName() + ": findCoach()");
	return new Account(id, "coach");
    }

    public List<Account> findCoaches(boolean isThrow) throws Exception {
	System.out.println(getClass().getSimpleName() + ": findCoaches()");

	// simulate exception
	if (isThrow) {

	    throw new Exception("Account not found!");
	}
	return Arrays.asList(new Account(1, "admin"), new Account(2, "coach"), new Account(3, "sys"));
    }

}
