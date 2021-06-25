package com.spring.boot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.demo.dao.EmployeeDao;
import com.spring.boot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // ① plug-in Hibernate impl
    // @Autowired
    // @Qualifier("employeeDaoHibernateImpl")
    // private EmployeeDao employeeDao;

    // ② plug-in JPA
    @Autowired
    @Qualifier("employeeDaoJpaImpl")
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAll() {
	return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
	return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
	employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
	employeeDao.update(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
	employeeDao.delete(id);
    }

}
