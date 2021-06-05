package com.spring.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Customer;

// @Component
@Repository
public class CustomerDaoImpl implements CustomerDao {

    // inject Hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    // ❗️@Transactional MOVE TO Service layer
    @Override
    public List<Customer> getCustomers() {
	// get current session
	Session session = sessionFactory.getCurrentSession();
	// 🤯 @Transactional will auto handle
	// session.beginTransaction();

	// select * from customer
	Query<Customer> query = session.createQuery("from Customer", Customer.class);
	List<Customer> customers = query.getResultList();
	return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
	Session session = sessionFactory.getCurrentSession();

	if (customer != null) {
	    session.save(customer);
	}
    }

}
