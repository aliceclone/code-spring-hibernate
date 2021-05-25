package config.demo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyLogger {

    public MyLogger(String rootLevel, String printLevel) {

	Logger contextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());

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
