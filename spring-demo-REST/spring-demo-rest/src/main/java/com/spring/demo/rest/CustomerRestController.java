package com.spring.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Customer;
import com.spring.demo.exception.UserNotFoundException;
import com.spring.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
	return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getSingleCustomer(@PathVariable("id") int id, BindingResult result) {
	System.out.println(result);
	// if Null -> Jackson will return empty body
	Customer customer = customerService.getCustomer(id);
	// handle manually
	if (customer == null) {
	    throw new UserNotFoundException("User id " + id + " is not found!");
	}
	return customer;
    }

}
