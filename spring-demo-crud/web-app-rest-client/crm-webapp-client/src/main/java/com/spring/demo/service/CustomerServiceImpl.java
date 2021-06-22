package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.CustomerDao;
import com.spring.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    // ❗
    @Override
    public List<Customer> getCustomers() {
	return customerDao.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
	customerDao.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(int id) {
	return customerDao.getCustomer(id);
    }

    @Override
    public void deleteCustomer(int id) {
	customerDao.deleteCustomer(id);
    }

}
