package com.spring.boot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.demo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    // inject entity manager, spring boot auto created bean for entityManager
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllEmployee() {
	// get session
	Session session = entityManager.unwrap(Session.class);
	// query
	Query<Employee> createQuery = session.createQuery("from Employee", Employee.class);
	return createQuery.getResultList();
    }

    @Override
    public Employee findEmployeeById(int theId) {
	// get session
	Session session = entityManager.unwrap(Session.class);
	// get employee
	Query<Employee> createQuery = session.createQuery("from Employee where id=:theId", Employee.class);
	createQuery.setParameter("theId", theId);
	// get single
	return createQuery.getSingleResult();
    }

    @Override
    public void save(Employee employee) {
	// get session
	Session session = entityManager.unwrap(Session.class);
	session.save(employee);
    }

    @Override
    public void update(Employee employee) {
	// get session
	Session session = entityManager.unwrap(Session.class);
	session.update(employee);
    }

    @Override
    public void delete(int theId) {
	// get session
	Session session = entityManager.unwrap(Session.class);
	// query
	Query createQuery = session.createQuery("delete Employee where id=:theId");
	createQuery.setParameter("theId", theId);
	// delete
	createQuery.executeUpdate();
    }

}
