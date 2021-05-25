package com.spring.demo.annotation;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuotesFortuneService implements FortuneService {

    // Practice Activity #5 - DI with file load

    // read the fortunes from a file
    // @Value("${quote.array}")
    @Value("#{'${quote.array}'.split(';')}")
    // load the fortunes into an array
    private String[] quoteArray;
    private String todayQuote;

    @Override
    public String getFortune() {
	return "[QuotesFortuneService] " + todayQuote;
    }

    // Practice Activity #6 - Bean Scopes with @PostConstruct Annotations
    @PostConstruct
    private void genQuote() {
	Random random = new Random();
	// random fortune from the array
	int bound = quoteArray.length;
	todayQuote = quoteArray[random.nextInt(bound)];
    }
}
