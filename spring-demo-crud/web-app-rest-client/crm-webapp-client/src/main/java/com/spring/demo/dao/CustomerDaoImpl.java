package com.spring.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.demo.entity.Customer;

// @Component
@Repository
public class CustomerDaoImpl implements CustomerDao {

    // inject rest
    @Autowired
    private RestTemplate restTemplate;

    @Value("${crm.endpoint}")
    private String crmEndpoint;

    @Override
    public List<Customer> getCustomers() {
	ParameterizedTypeReference<List<Customer>> responseType = new ParameterizedTypeReference<List<Customer>>() {
	};
	// retrieve ResponseEntity by doing a GET on the specified URL
	ResponseEntity<List<Customer>> exchange = restTemplate.exchange(crmEndpoint, HttpMethod.GET, null,
		responseType);
	// 🤯 Spring auto convert by using Jackson
	List<Customer> customers = exchange.getBody();
	return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
	int id = customer.getId();
	// controller already filter save & update
	// if id is 0 save
	if (id == 0) {
	    // save
	    restTemplate.postForEntity(crmEndpoint, customer, Customer.class);
	} else {
	    // update
	    restTemplate.put(crmEndpoint, customer);
	}
    }

    @Override
    public Customer getCustomer(int id) {
	String url = String.format("%s/%s", crmEndpoint, id);
	// retrieve a representation by doing a GET on the specified URL
	Customer customer = restTemplate.getForObject(url, Customer.class);
	return customer;
    }

    @Override
    public void deleteCustomer(int id) {
	String url = String.format("%s/%s", crmEndpoint, id);
	restTemplate.delete(url);
    }

}
