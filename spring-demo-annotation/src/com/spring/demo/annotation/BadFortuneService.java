package com.spring.demo.annotation;

import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "[BadFortuneService] ";
    }

}
