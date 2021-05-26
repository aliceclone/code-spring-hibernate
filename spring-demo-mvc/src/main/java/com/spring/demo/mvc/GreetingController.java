package com.spring.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping("/showGreet")
	public String displayForm() {
		return "greet-form";

	}

	@RequestMapping("/greet")
	public String displayGreet() {
		return "greet";
	}

	// get form data
	// add to model
	@RequestMapping("/shout")
	public String shout(HttpServletRequest request, Model model) {

		// get
		String param = request.getParameter("name");

		// process
		String upperCase = "What's up! " + param.toUpperCase();

		// add to model
		model.addAttribute("message", upperCase);
		return "greet";
	}

}
