package noxml.spring.demo.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.demo.annotation.Coach;
import com.spring.demo.annotation.FortuneService;

@Configuration
// @Component("com.spring.demo.annotation")
@PropertySource("classpath:data.properties")
public class NoXmlConfig {

	// define bean FortuneService
	// method name == bean Id
	@Bean
	public FortuneService badFortuneService() {
		return new BadFortuneService();
	}

	// define and DI bean VolleyballCoach
	@Bean
	public Coach getVolleyballCoach() {
		return new VolleyballCoach(badFortuneService());
	}

	// Spring 4.2 and lower cannot use ${...}
	// need to add following explicitly
	/*
	 * @Bean public static PropertySourcesPlaceholderConfigurer
	 * propertySourcesPlaceHolderConfigurer() { return new
	 * PropertySourcesPlaceholderConfigurer(); }
	 */

}
