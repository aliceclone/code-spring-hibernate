package com.spring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
