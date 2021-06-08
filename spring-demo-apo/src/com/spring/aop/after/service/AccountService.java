package com.spring.aop.after.service;

import org.springframework.stereotype.Component;

import com.spring.aop.after.dao.OtherAccountDao;

@Component
public class AccountService {

    private OtherAccountDao accountDao;

    private String level;

    public String getLevel() {
	System.out.println(getClass().getSimpleName() + ": getLevel() \n");
	return level;
    }

    public void setLevel(String level) {
	System.out.println(getClass().getSimpleName() + ": setLevel() \n");
	this.level = level;
    }

    public void combo(com.spring.entity.Account account) {
	System.out.println(getClass().getSimpleName() + ": combo() \n");
	System.out.println("");
    }

    public OtherAccountDao getAccountDao() {
	System.out.println(getClass().getSimpleName() + ": getAccountDao() \n");
	return accountDao;
    }

    public void setAccountDao(OtherAccountDao accountDao) {
	System.out.println(getClass().getSimpleName() + ": setAccountDao() \n");
	this.accountDao = accountDao;
    }

}
