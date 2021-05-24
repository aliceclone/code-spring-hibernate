package com.spring.demo.annotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] data = { "Decide your own destiny.", "You cannot control what's happening.",
	    "I\'m closer than I was yesterday." };

    private Random random = new Random();

    @Override
    public String getFortune() {
	System.out.println("[RandomFortuneService] ");
	return data[random.nextInt(data.length)];
    }

}
