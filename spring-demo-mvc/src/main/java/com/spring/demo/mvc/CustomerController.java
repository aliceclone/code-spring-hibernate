package com.spring.demo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// this will call auto
	// init model
	@ModelAttribute
	public Customer setUp() {
		return new Customer();
	}

	@RequestMapping("/form")
	public String showForm() {
		return "customer-form";
	}

	// retrieve model
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute Customer customer, BindingResult result) {

		if (result.hasErrors()) {
			return showForm();
		}

		return "customer-confirmation";
	}

}
