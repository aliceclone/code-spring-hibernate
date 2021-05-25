package noxml.spring.demo.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

import com.spring.demo.annotation.Coach;
import com.spring.demo.annotation.FortuneService;

public class VolleyballCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${data.email}")
	private String email;

	@Value("${data.team}")
	private String team;

	public VolleyballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Passing the ball to the teammate.";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
