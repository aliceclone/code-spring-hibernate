package com.spring.demo.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/greet")
    public String greet(Model model) {
	model.addAttribute("msg", LocalTime.now());
	// auto map /templates/*.html
	return "greet";
    }
}
