package com.spring.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController1 {

	// way 1
	@RequestMapping("/form")
	public String showForm(Model model) {
		System.out.println("[StudentController] showForm");

		// init student form
		// add student to model attribute
		model.addAttribute(new Student());

		// return view
		return "student-form";
	}

	// Argument Level:
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute Student student) {

		System.out.println("[StudentController] processForm "
				+ student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";
	}

}
