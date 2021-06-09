package com.spring.aop.around.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class CakeService {

    public String bakeCake(boolean isThrow) throws Exception {
	System.out.println(getClass().getSimpleName() + ": 👩🏽‍🍳");

	// simulate exception
	if (isThrow) {
	    throw new Exception("We're close today!");
	}

	// delay
	try {
	    TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	System.out.println(getClass().getSimpleName() + ": ✅ Done!");
	return "Sorry for waiting! Here are your 🍰";
    }

}
