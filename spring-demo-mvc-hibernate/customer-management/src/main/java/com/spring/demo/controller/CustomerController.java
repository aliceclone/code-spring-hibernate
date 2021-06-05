package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @ModelAttribute
    public Customer setUp() {
	return new Customer();
    }

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String list(Model model) {

	// fetch customers
	List<Customer> customers = customerService.getCustomers();

	// add to model
	model.addAttribute("customers", customers);
	// view
	return "customer-list";
    }

    @GetMapping("/formAdd")
    public String formAdd() {
	// @ModelAttribute Customer no need to bind
	return "customer-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
	// save
	customerService.addCustomer(customer);
	// ❗PRG flow implemented
	return "redirect:/customer/success";
    }

    @GetMapping("/success")
    public String success(Model model) {
	return list(model);
    }

}
