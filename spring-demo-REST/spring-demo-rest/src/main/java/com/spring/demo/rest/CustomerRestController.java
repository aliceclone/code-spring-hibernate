package com.spring.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Customer getSingleCustomer(@PathVariable("id") int id) {
	// if Null -> Jackson will return empty body
	Customer customer = customerService.getCustomer(id);
	System.out.println("📍️getSingleCustomer: " + customer);
	// handle manually
	if (customer == null) {
	    throw new UserNotFoundException("User id " + id + " is not found!");
	}
	return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
	// ❗null or 0 -> hibernate will do SAVE
	// explicitly add [0] to make sure user fault avoid (mistakenly update)
	customer.setId(0);
	customerService.saveCustomer(customer);
	return customer;
    }

}
