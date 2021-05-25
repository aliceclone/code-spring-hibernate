package config.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.demo.annotation.Coach;

public class MainBeanApp {

	public static void main(String[] args) {

		// test log with @Bean
		AnnotationConfigApplicationContext contextWithBean = new AnnotationConfigApplicationContext(
				SpringConfigWithBean.class);
		Coach sillyCoach = contextWithBean.getBean("sillyCoach", Coach.class);
		System.out.println(sillyCoach.getDailyWorkout());
		System.out.println(sillyCoach.getFortune());

		// close
		contextWithBean.close();

	}

}
