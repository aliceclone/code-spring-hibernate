package com.spring.demo.config;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class<?>[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
	logger.info("📍 getServletFilters");
	// encoding filter must be the first one
	CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	// both setForceRequestEncoding and setForceResponseEncoding > true
	encodingFilter.setForceEncoding(true);
	encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
	return new Filter[] { encodingFilter };

    }

}
