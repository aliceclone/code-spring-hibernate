package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.entity.Customer;
import com.spring.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    // ❗ /customers GET -> list
    // /customers POST -> save OR update
    // /customers/update/{id} -> update form

    // ❗without service layer: private CustomerDao customerDao;
    @Autowired
    private CustomerService customerService;

    @ModelAttribute(name = "customerForm")
    public Customer setUp() {
	return new Customer();
    }

    @GetMapping
    public String list(Model model) {
	// fetch customers
	List<Customer> customers = customerService.getCustomers();
	// add to model
	model.addAttribute("customers", customers);
	// view
	return "customer-list";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute("customerForm") Customer customer) {
	// save
	customerService.saveCustomer(customer);
	// ❗PRG flow implemented
	return "redirect:/customers";
    }

    @GetMapping("/add")
    public String formAdd() {
	// @ModelAttribute Customer no need to bind
	return "customer-form";
    }

    @GetMapping(path = "/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model) {
	// @RequestParam("customerId") can also use with c:url
	Customer customer = customerService.getCustomer(id);
	model.addAttribute("customerForm", customer);
	return "customer-form";
    }

}
