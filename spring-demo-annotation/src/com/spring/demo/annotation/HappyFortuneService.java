package com.spring.demo.annotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "Lucky sunny day!";
    }

}
