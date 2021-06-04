package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.dao.CustomerDao;
import com.spring.demo.entity.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    // scan and inject
    @Autowired
    private CustomerDao customerDao;

//    @ModelAttribute
//    public List<Customer> setUp() {
//
//	return new ArrayList<Customer>();
//    }

    @RequestMapping(value = "/list")
    public String showList(Model model) {

	// fetch customers
	List<Customer> customers = customerDao.getCustomers();

	// add to model
	model.addAttribute("customers", customers);

	return "customer-list";
    }

}
