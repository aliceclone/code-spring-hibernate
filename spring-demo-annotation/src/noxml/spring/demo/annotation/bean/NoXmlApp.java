package noxml.spring.demo.annotation.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXmlApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				NoXmlConfig.class);

		VolleyballCoach volleyballCoach = context.getBean("getVolleyballCoach",
				VolleyballCoach.class);
		System.out.println(volleyballCoach.getDailyWorkout());
		System.out.println(volleyballCoach.getFortune());

		System.out.println(
				volleyballCoach.getEmail() + " - " + volleyballCoach.getTeam());

		// close
		context.close();

	}

}
