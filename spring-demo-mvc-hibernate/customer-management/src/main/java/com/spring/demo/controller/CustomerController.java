package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.entity.Customer;
import com.spring.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // scan and inject
    // ❗ private CustomerDao customerDao;
    @Autowired
    private CustomerService customerService;

//    @ModelAttribute
//    public List<Customer> setUp() {
//
//	return new ArrayList<Customer>();
//    }

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String showList(Model model) {

	// fetch customers
	List<Customer> customers = customerService.getCustomers();

	// add to model
	model.addAttribute("customers", customers);

	return "customer-list";
    }

}
