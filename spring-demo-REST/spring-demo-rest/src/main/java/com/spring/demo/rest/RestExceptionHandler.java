package com.spring.demo.rest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.exception.UserNotFoundException;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    // handle specific exception
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> userNotFoundException(UserNotFoundException userNotFoundException) {
	CommonErrorResponse error = new CommonErrorResponse(HttpStatus.NOT_FOUND.value(),
		userNotFoundException.getMessage(), System.currentTimeMillis());
	// response 404
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
