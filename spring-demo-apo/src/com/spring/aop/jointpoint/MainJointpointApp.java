package com.spring.aop.jointpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.jointpoint.dao.MemberDao;
import com.spring.entity.Account;

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
