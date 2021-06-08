package com.spring.aop.jointpoint.dao;

import org.springframework.stereotype.Component;

import com.spring.entity.Account;

@Component
public class MemberDao {

    private int id;

    public int getId() {
	System.out.println(getClass().getSimpleName() + ": getId()");
	return id;
    }

    public void setId(int id) {
	System.out.println(getClass().getSimpleName() + ": setId()");
	this.id = id;
    }

    public void getMemebrAccount(Account account, int code) {
	System.out.println(getClass().getSimpleName() + ": getMemebrAccount()");
	System.out.println("");
    }

}
