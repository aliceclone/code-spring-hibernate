package com.spring.demo;

import java.util.Random;

public class RandomFortune implements FortuneService {

    final String[] genFortune = { "lucky", "normal", "bad" };

    @Override
    public String getFortune() {
	// create instance of Random class
	Random rand = new Random();
	// get random fortune
	return "Random: " + genFortune[rand.nextInt(3)];
    }

}
