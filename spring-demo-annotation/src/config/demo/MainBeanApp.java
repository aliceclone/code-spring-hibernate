package config.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.annotation.Coach;

public class MainBeanApp {

	public static void main(String[] args) {

		// test log with @Bean
		AnnotationConfigApplicationContext contextWithBean = new AnnotationConfigApplicationContext(
				SpringConfigWithBean.class);
		Coach swimmingCoach = contextWithBean.getBean("swimmingCoach",
				Coach.class);
		System.out.println(swimmingCoach.getDailyWorkout());
		System.out.println(swimmingCoach.getFortune());

		// close
		contextWithBean.close();

	}

}
