package com.spring.demo.service;

import java.util.List;

import com.spring.demo.entity.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

    public Customer getCustomer(int id);

}
