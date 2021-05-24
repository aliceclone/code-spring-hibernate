package com.spring.demo;

import org.springframework.beans.factory.DisposableBean;

public class FootballCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
	this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
	return "Kick a ball.";
    }

    @Override
    public String getDailyFortune() {
	return "The pitch is yours." + fortuneService.getFortune();
    }

    private void doPrivately() {
	System.out.println("[FootballCoach - doPrivately]");
    }

    protected void cleanupMess() {
	System.out.println("[FootballCoach - cleanupMess]");
    }

    @Override
    public void destroy() throws Exception {
	cleanupMess();
    }

}
