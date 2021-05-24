package com.spring.demo.annotation;

import org.springframework.stereotype.Component;

@Component
public class DefaultFortuneService implements FortuneService {

    @Override
    public String getFortune() {
	return "[DefaultFortuneService] ";
    }

}
