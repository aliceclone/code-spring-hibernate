package com.spring.demo;

import java.util.Random;

public class RandomFortune implements FortuneService {

    final String[] genFortune = { "lucky", "normal", "bad" };

    // create instance of Random class
    private Random rand = new Random();

    @Override
    public String getFortune() {
	// get random fortune
	return "Random: " + genFortune[rand.nextInt(genFortune.length)];
    }

}
