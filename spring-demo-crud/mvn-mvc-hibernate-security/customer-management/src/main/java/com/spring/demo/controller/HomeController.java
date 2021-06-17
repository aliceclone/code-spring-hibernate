package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
	// all can access without login
	return "index";
    }

    @GetMapping("/home")
    public String home() {
	return "home";
    }

    @GetMapping("/managers")
    public String leaderPage() {
	return "manager-home";
    }

    @GetMapping("/systems")
    public String systemPage() {
	return "system-home";
    }

}
