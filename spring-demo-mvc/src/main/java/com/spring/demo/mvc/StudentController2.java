package com.spring.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student2")
public class StudentController2 {

	// way 2
	// Method Level: return value of this method is interpreted as a model
	// attribute
	@ModelAttribute
	public Student setUp() {
		// setUp() method will load, everytime this controller is called
		// but new Student() will create ONLY one time
		System.out.println("[StudentController] setUp");

		// following code will override only once
		// Student student = new Student();
		// student.setFirstName("First");
		return new Student();
	}

	// way 2 continue
	@RequestMapping("/form")
	public String showForm() {
		System.out.println("[StudentController] showForm");
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
