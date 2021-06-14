package com.spring.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.demo")
@PropertySource("classpath:/application.properties")
public class AppConfig implements WebMvcConfigurer {

    // inject environment
    @Autowired
    Environment env;

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver internalResourceViewResolver() {

	String prefix = "/WEB-INF/view/";
	String suffix = ".jsp";

	return new InternalResourceViewResolver(prefix, suffix);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//	registry.jsp("/WEB-INF/view/", ".jsp");
//    };

    // get dataSoruce
    @Bean
    public DataSource comboPooledDataSource() {

	// define jdbc
	ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

	logger.info(env.getProperty("jdbc.url"));

	try {

	    comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));

	} catch (PropertyVetoException e) {
	    throw new RuntimeException(e);
	}
	comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
	comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));

	// connection pool

	comboPooledDataSource.setInitialPoolSize(convertInt("connection.pool.initialPoolSize"));
	comboPooledDataSource.setMinPoolSize(convertInt("connection.pool.minPoolSize"));
	comboPooledDataSource.setMaxPoolSize(convertInt("connection.pool.maxPoolSize"));
	comboPooledDataSource.setMaxIdleTime(convertInt("connection.pool.maxIdleTime"));

	return comboPooledDataSource;

    }

    private int convertInt(String key) {
	return Integer.parseInt(env.getProperty(key));
    }

}
