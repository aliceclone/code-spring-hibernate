package com.spring.data.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
