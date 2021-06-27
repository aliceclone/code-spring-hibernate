package com.spring.demo.service;

import java.util.List;

import com.spring.demo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(int id);

}
