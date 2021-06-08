package com.spring.jointpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.demo.aop.entity.Account;
import com.spring.jointpoint.dao.MemberDao;

public class MainJointpointApp {

    public static void main(String[] args) {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	MemberDao member = context.getBean("memberDao", MemberDao.class);

	Account account = new Account();
	account.setLevel("Admin");

	member.getMemebrAccount(account, 101);

	context.close();

    }

}
