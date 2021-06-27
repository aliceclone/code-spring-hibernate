package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.entity.Employee;
import com.spring.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model) {

	// fetch data
	List<Employee> employees = employeeService.findAll();
	// add to model
	model.addAttribute("employees", employees);
	return "employee-list";
    }
}
