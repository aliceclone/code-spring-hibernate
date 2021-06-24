package com.spring.boot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.demo.dao.EmployeeDao;
import com.spring.boot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAllEmployee() {
	return employeeDao.findAllEmployee();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
	return employeeDao.findEmployeeById(id);
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
