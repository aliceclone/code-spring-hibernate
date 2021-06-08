package com.spring.aop.afterreturn.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Component
public class CustomerDao {

    private int id;

    public int getId() {
	System.out.println(getClass().getSimpleName() + ": getId()");
	return id;
    }

    public void setId(int id) {
	System.out.println(getClass().getSimpleName() + ": setId()");
	this.id = id;
    }

    public Account findCustomer(int id) {
	System.out.println(getClass().getSimpleName() + ": findCustomer()");
	return new Account(id, "member");
    }

    public List<Account> findCustomers() {
	System.out.println(getClass().getSimpleName() + ": findCustomers()");

	return Arrays.asList(new Account(1, "admin"), new Account(2, "member"), new Account(3, "sys"));
    }

}
