package config.demo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource("classpath:log.properties"),
		@PropertySource("classpath:data.properties")})
@ComponentScan("com.spring.demo.annotation")
public class SpringConfig {

	@Value("${root.logger.level}")
	private String rootLevel;

	@Value("${printed.logger.level}")
	private String printLevel;

	@PostConstruct
	public void init() {

		Logger contextLogger = Logger
				.getLogger(AnnotationConfigApplicationContext.class.getName());

		// set root logging level
		Logger parentLogger = contextLogger.getParent();
		parentLogger.setLevel(Level.parse(rootLevel));

		// set console level
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.parse(printLevel));
		consoleHandler.setFormatter(new SimpleFormatter());

		// set handler
		parentLogger.addHandler(consoleHandler);

	}

}
