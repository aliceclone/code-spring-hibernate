package com.spring.aop.afterreturn;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.SpringConfig;
import com.spring.aop.afterreturn.dao.CustomerDao;
import com.spring.entity.Account;

public class MainAfterReturnApp {

    public static void main(String[] args) {

	// load configuration
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// get bean
	CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);

	// logic

	Account customer = customerDao.findCustomer(1);
	System.out.println(customer);

	System.out.println();

	List<Account> customers = customerDao.findCustomers();

	System.out.println(customers);

	// close
	context.close();

    }

}
