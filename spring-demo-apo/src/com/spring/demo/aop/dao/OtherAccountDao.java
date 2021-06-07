package com.spring.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class OtherAccountDao {

    public void addAccount() {
	System.out.println(getClass().getSimpleName() + ": addAccount() \n");
    }

    public String updateSomething() {
	System.out.println(getClass().getSimpleName() + ": updateSomething() \n");
	return "";
    }

}
