package com.spring.boot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
