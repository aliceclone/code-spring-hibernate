package com.spring.boot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.demo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllEmployee() {
	// create query
	TypedQuery<Employee> createQuery = entityManager.createQuery("from Employee", Employee.class);
	// return result
	return createQuery.getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
	Employee employee = entityManager.find(Employee.class, id);
	return employee;
    }

    @Override
    public void save(Employee employee) {
	entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
	// whatever ID have or haven't merge
	Employee newEmployee = entityManager.merge(employee);
	// explicitly set Auto Gen id :(, to response with id in JSON
	employee.setId(newEmployee.getId());
    }

    @Override
    public void delete(int theId) {
	// create query
	// ❗❗️JPA : javax.persistence.Query, not Hibernate
	Query createQuery = entityManager.createQuery("delete from Employee where id=:theId");
	createQuery.setParameter("theId", theId);
	// execute
	createQuery.executeUpdate();
    }

}
