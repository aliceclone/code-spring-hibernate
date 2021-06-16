package com.spring.demo.config;

import java.beans.PropertyVetoException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
@ComponentScan("com.spring.demo")
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    Environment env;

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    // ❗ message resolution to a bean with the exact name
    @Bean
    public MessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:messages");
	messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
	return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource crmDataSource() {
	logger.info("📍 Connecting..." + env.getProperty("jdbc.url"));
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	// jdbc
	try {
	    dataSource.setDriverClass(env.getProperty("jdbc.driver"));
	} catch (PropertyVetoException e) {
	    logger.severe("📍 Fail to connect..." + env.getProperty("jdbc.url"));
	    e.printStackTrace();
	    throw new RuntimeException("Fail to connect to DB.");

	}
	dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	dataSource.setUser(env.getProperty("jdbc.user"));
	dataSource.setPassword(env.getProperty("jdbc.password"));

	// setup connection pool
	connectionPool(dataSource);

	return dataSource;

    }

    @Bean
    public LocalSessionFactoryBean crmSessionFactory() {
	// create hibernate session factory through spring
	logger.info("📍Creating [LocalSessionFactoryBean] hibernate session factory through spring");
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// set c3p0
	sessionFactory.setDataSource(crmDataSource());
	// hibernate annotation scan
	sessionFactory.setPackagesToScan(env.getProperty("hiberante.packagesToScan"));
	// set hibernate props
	sessionFactory.setHibernateProperties(hibernateProperties());
	return sessionFactory;

    }

    // ❗@Autowired is used️
    @Bean
    @Autowired
    public HibernateTransactionManager crmTxManager(SessionFactory crmSessionFactory) {
	logger.info("📍 Creating [HibernateTransactionManager]");
	HibernateTransactionManager tx = new HibernateTransactionManager();
	tx.setSessionFactory(crmSessionFactory);
	return tx;
    }

    private Properties hibernateProperties() {
	logger.info("📍 Setting hibernate properties");
	// set hibernate properties
	Properties props = new Properties();
	props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
	return props;
    }

    private void connectionPool(ComboPooledDataSource dataSource) {
	logger.info("📍 Setting connection pool properties");
	dataSource.setInitialPoolSize(convertInt("connection.pool.initialPoolSize"));
	dataSource.setMinPoolSize(convertInt("connection.pool.minPoolSize"));
	dataSource.setMaxPoolSize(convertInt("connection.pool.maxPoolSize"));
	dataSource.setMaxIdleTime(convertInt("connection.pool.maxIdleTime"));
    }

    // ❗Not sure when this will need
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter() {
//        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
//    }

    private int convertInt(String key) {
	return Integer.parseInt(env.getProperty(key));
    }

}
