package com.spring.demo.annotation;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuotesFortuneService implements FortuneService {

    // read the fortunes from a file
    // @Value("${quote.array}")
    @Value("#{'${quote.array}'.split(';')}")
    // load the fortunes into an array
    private String[] quoteArray;

    private Random random = new Random();

    @Override
    public String getFortune() {
	// random fortune from the array
	int bound = quoteArray.length;
	return "[QuotesFortuneService] " + quoteArray[random.nextInt(bound)];
    }

}
