package config.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.spring.demo.annotation.FortuneService;
import com.spring.demo.annotation.RandomFortuneService;
import com.spring.demo.annotation.SwimmingCoach;

@Configuration
@PropertySources({@PropertySource("classpath:log.properties"),
		@PropertySource("classpath:data.properties")})
// @ComponentScan("com.spring.demo.annotation")
public class SpringConfigWithBean {

	@Bean
	public MyLogger initLogConfig(
			@Value("${root.logger.level}") String rootLevel,
			@Value("${printed.logger.level}") String printLevel) {

		return new MyLogger(rootLevel, rootLevel);
	}

	@Bean
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}

	@Bean
	public SwimmingCoach swimmingCoach() {
		SwimmingCoach swimmingCoach = new SwimmingCoach();
		swimmingCoach.setFortuneService(randomFortuneService());
		return swimmingCoach;
	}

}
