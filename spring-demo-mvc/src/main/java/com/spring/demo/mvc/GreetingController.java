package com.spring.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hi")
public class GreetingController {

	@RequestMapping("/showForm")
	public String displayForm() {
		return "greet-form";

	}

	// way 1
	// no model use
	@RequestMapping("/greet")
	public String displayGreet() {
		return "greet";
	}

	// way 2
	// get form data
	// add to model
	@RequestMapping("/servletShout")
	public String shout(HttpServletRequest request, Model model) {

		// get
		String param = request.getParameter("name");

		// process
		String upperCase = "What's up! " + param.toUpperCase();

		// add to model
		model.addAttribute("message", upperCase);
		return "greet";
	}

	// way 3
	// bind with param
	@RequestMapping("/shout")
	// @RequestParam("name") in case param name and form name is different
	public String shout2(@RequestParam String name, Model model) {
		model.addAttribute("message", "Yo Yo! " + name.toUpperCase());
		return "greet";
	}

}
