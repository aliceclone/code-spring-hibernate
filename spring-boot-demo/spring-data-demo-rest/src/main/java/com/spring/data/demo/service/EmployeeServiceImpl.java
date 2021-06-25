package com.spring.data.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.demo.entity.Employee;
import com.spring.data.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
	return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
	Optional<Employee> result = employeeRepository.findById(id);

	if (!result.isPresent()) {
	    throw new RuntimeException("Did not found id " + id);
	}
	return result.get();
    }

    @Override
    public void save(Employee employee) {
	employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
	// ❗❗️LOL
	employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
	employeeRepository.deleteById(id);
    }

}
