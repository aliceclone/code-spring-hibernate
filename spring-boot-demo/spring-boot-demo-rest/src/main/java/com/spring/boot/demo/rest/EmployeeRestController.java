package com.spring.boot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.boot.demo.entity.Employee;
import com.spring.boot.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
	return employeeService.findAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
	Employee employee = employeeService.findEmployeeById(id);
	if (employee == null) {
	    throw new RuntimeException("employee id: " + id + " not found");
	}
	return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
	// if id is passed, save() will ignore and insert new row
	employeeService.save(employee);
	return employee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
	try {
	    // if id is not passed, update() throw StaleObjectStateException
	    employeeService.update(employee);
	} catch (Exception ex) {
	    String error = "Id " + employee.getId() + " is not found.";
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, error);
	}

	return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {

	// pre check
	Employee employee = employeeService.findEmployeeById(id);
	System.out.println("delete>> " + employee);
	if (employee == null) {
	    String error = "Id " + id + " is not found.";
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, error);
	}

	employeeService.delete(id);
	// return raw string
	return "Id " + id + " is deleted.";
    }

}
