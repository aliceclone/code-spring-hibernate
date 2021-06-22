package com.spring.demo.config;

import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    // ❗️DispatcherServlet sends error response without throwing exception
    // to throw [404] as exception and catch at handleNoHandlerFoundException()
    protected void customizeRegistration(Dynamic registration) {
	registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}
