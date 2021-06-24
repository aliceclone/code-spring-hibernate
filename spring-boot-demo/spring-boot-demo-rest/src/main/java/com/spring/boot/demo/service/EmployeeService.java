package com.spring.boot.demo.service;

import java.util.List;

import com.spring.boot.demo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public Employee findEmployeeById(int id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(int id);

}
