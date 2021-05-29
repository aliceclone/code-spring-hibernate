package com.spring.demo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController1 {

	@Value("#{countryOptionsB}")
	private Map<String, String> countryOptionsB;

	// way 1
	@RequestMapping("/form")
	public String showForm(Model model) {
		System.out.println("[StudentController] showForm");

		// init student form
		// add student to model attribute
		model.addAttribute(new Student());

		// add properties data to model
		model.addAttribute("countryOptionsB", countryOptionsB);

		// return view
		return "student-form";
	}

	// Argument Level:
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute Student student, @ModelAttribute Map<String, String> countryOptionsB) {

		System.out.println("[StudentController] processForm " + student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";
	}

}
