package com.spring.demo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.spring.demo")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    // define a bean for ViewResolver

    @Bean
    public DataSource dataSource() {

	// create connection pool
	ComboPooledDataSource myDataSource = new ComboPooledDataSource();

	// set the jdbc driver
	try {
	    myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
	} catch (PropertyVetoException exc) {
	    throw new RuntimeException(exc);
	}

	// for sanity's sake, let's log url and user ... just to make sure we are
	// reading the data
	logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
	logger.info("jdbc.user=" + env.getProperty("jdbc.user"));

	// set database connection props
	myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	myDataSource.setUser(env.getProperty("jdbc.user"));
	myDataSource.setPassword(env.getProperty("jdbc.password"));

	// set connection pool props
	connectionPool(myDataSource);

	return myDataSource;
    }

    private void connectionPool(ComboPooledDataSource dataSource) {
	logger.info("📍 Setting connection pool properties");
	dataSource.setInitialPoolSize(convertInt("connection.pool.initialPoolSize"));
	dataSource.setMinPoolSize(convertInt("connection.pool.minPoolSize"));
	dataSource.setMaxPoolSize(convertInt("connection.pool.maxPoolSize"));
	dataSource.setMaxIdleTime(convertInt("connection.pool.maxIdleTime"));
    }

    private Properties getHibernateProperties() {

	// set hibernate properties
	Properties props = new Properties();

	props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
	return props;
    }

    // need a helper method
    // read environment property and convert to int

    private int convertInt(String propName) {

	String propVal = env.getProperty(propName);

	// now convert to int
	int intPropVal = Integer.parseInt(propVal);

	return intPropVal;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

	// create session factorys
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	// set the properties
	sessionFactory.setDataSource(dataSource());
	sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
	sessionFactory.setHibernateProperties(getHibernateProperties());

	return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

	// setup transaction manager based on session factory
	HibernateTransactionManager txManager = new HibernateTransactionManager();
	txManager.setSessionFactory(sessionFactory);

	return txManager;
    }

}
