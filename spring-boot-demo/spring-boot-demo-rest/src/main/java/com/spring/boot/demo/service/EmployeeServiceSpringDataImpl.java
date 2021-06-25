package com.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.demo.entity.Employee;
import com.spring.boot.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceSpringDataImpl implements EmployeeService {

    // ① plug-in Hibernate impl
    // @Autowired
    // @Qualifier("employeeDaoHibernateImpl")
    // private EmployeeDao employeeDao;

    // ② plug-in JPA
    // @Autowired
    // @Qualifier("employeeDaoJpaImpl")
    // private EmployeeDao employeeDao;

    // ③ plug-in Spring Data JPA
    // ❗❗️@Transactional IS NOT NECESSARY
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
