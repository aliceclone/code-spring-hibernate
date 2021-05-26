package com.spring.demo.mvc;

import org.springframework.stereotype.Controller;
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

}
