package com.spring.demo.service;

import java.util.List;

import javax.transaction.Transactional;

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
    @Transactional
    public List<Customer> getCustomers() {
	return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
	customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
	return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
	customerDao.deleteCustomer(id);
    }

}
