package com.spring.boot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    // inject from application.properties
    @Value("${greet.default}")
    private String greet;

    @GetMapping("/")
    public String greet() {
	return greet + " " + LocalDateTime.now();
    }

}
