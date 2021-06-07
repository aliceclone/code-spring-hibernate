package com.spring.demo.aop.service;

import org.springframework.stereotype.Component;

import com.spring.demo.aop.dao.AccountDao;
import com.spring.demo.aop.entity.Account;

@Component
public class AccountService {

    private AccountDao accountDao;

    private String level;

    public String getLevel() {
	System.out.println(getClass().getSimpleName() + ": getLevel() \n");
	return level;
    }

    public void setLevel(String level) {
	System.out.println(getClass().getSimpleName() + ": setLevel() \n");
	this.level = level;
    }

    public void combo(Account account) {
	System.out.println(getClass().getSimpleName() + ": combo() \n");
	System.out.println("");
    }

    public AccountDao getAccountDao() {
	System.out.println(getClass().getSimpleName() + ": getAccountDao() \n");
	return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
	System.out.println(getClass().getSimpleName() + ": setAccountDao() \n");
	this.accountDao = accountDao;
    }

}
