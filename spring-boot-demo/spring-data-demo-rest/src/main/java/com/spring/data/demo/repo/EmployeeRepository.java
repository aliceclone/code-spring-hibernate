package com.spring.data.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.data.demo.entity.Employee;

@RepositoryRestResource(path = "teams")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
