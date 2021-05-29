package com.spring.demo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

		System.out.println("|" + customer.getFirstName() + "|");
		if (result.hasErrors()) {
			return showForm();
		}

		return "customer-confirmation";
	}

	// register controller-specific, trim leading and trailing whitespace
	@InitBinder
	public void trimString(WebDataBinder binder) {
		// true for empty as null
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

	}

}
