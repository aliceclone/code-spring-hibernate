package com.spring.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    // validation BindingResult fails
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
	    WebRequest request) {
	logger.info(ex.getClass().getName());

	List<String> errors = new ArrayList<String>();
	for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
	    errors.add(error.getField() + ": " + error.getDefaultMessage());
	}
	for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	    errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	}
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors,
		System.currentTimeMillis());
	return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    // [400] exception to be thrown when validation on an argument annotated with
    // @Valid fails
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {
	logger.info(ex.getClass().getName());

	List<String> errors = new ArrayList<String>();
	for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	    errors.add(error.getField() + ": " + error.getDefaultMessage());
	}
	for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	    errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	}
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors,
		System.currentTimeMillis());

	// use handleExceptionInternal
	// return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(),
	// request);
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // [400]
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	logger.info(ex.getClass().getName());
	String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type "
		+ ex.getRequiredType();
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error,
		System.currentTimeMillis());
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // [404]
    // ❗DispatcherServlet sends error response without throwing Exception, to do so,
    // extra step require
    // XML::
    // <servlet>
    // <servlet-name>rest-dispatcher</servlet-name>
    // <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    // <init-param>
    // <param-name>throwExceptionIfNoHandlerFound</param-name>
    // <param-value>true</param-value>
    // </init-param>
    // </servlet>
    // Spring Boot :: spring.resources.add-mappings=false
    // spring.mvc.throw-exception-if-no-handler-found=true️
    // java ::
    // AbstractAnnotationConfigDispatcherServletInitializer of
    // @override customizeRegistration
    // setInitParameter("throwExceptionIfNoHandlerFound", "true");
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	logger.info(ex.getClass().getName());
	String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
	ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error,
		System.currentTimeMillis());
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // [405]
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {
	logger.info(ex.getClass().getName());

	StringBuilder error = new StringBuilder();
	error.append(ex.getMethod());
	error.append(" method is not supported for ");
	// error.append(ex.getValue());
	ex.getSupportedHttpMethods().forEach(x -> error.append(x));

	ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), error.toString(),
		System.currentTimeMillis());
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // [500] handle all exception
    @ExceptionHandler
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	logger.info(ex.getClass().getName());
	logger.error("error", ex);
	ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "error occured",
		System.currentTimeMillis());
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
