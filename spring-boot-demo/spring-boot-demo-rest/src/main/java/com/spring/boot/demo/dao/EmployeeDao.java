package com.spring.boot.demo.dao;

import java.util.List;

import com.spring.boot.demo.entity.Employee;

public interface EmployeeDao {

    public List<Employee> findAllEmployee();

    public Employee findEmployeeById(int id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(int id);

}
