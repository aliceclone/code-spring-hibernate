package com.spring.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaySomethingController {

	@RequestMapping("/showGreet")
	public String displayForm() {
		return "greet-form";

	}

	@RequestMapping("/greet")
	public String displayGreet() {
		return "greet";
	}

	// bind with param
	@RequestMapping("/shout")
	// @RequestParam("name") in case param name and form name is different
	public String shout2(@RequestParam("name") String param, Model model) {
		model.addAttribute("message", "Here we go! " + param.toUpperCase());
		return "greet";
	}

}
