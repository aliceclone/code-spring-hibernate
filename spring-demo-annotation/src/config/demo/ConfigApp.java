package config.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.annotation.Coach;

public class ConfigApp {

    public static void main(String[] args) {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	// Practice Activity #5 - DI with Annotations + properties
	Coach motivationCoach = context.getBean("motivationCoach", Coach.class);
	System.out.println(motivationCoach.getDailyWorkout());
	// Practice Activity #6 - Bean Scopes with @PostConstruct Annotations
	System.out.println(motivationCoach.getFortune());

	// close
	context.close();

    }

}
