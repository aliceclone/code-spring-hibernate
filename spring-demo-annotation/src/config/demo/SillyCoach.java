package config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.demo.annotation.Coach;
import com.spring.demo.annotation.FortuneService;

//@Component
public class SillyCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Fly 30 minutes a day.";
	}

	@Override
	public String getFortune() {
		return "[SillyCoach] " + fortuneService.getFortune();
	}

}
