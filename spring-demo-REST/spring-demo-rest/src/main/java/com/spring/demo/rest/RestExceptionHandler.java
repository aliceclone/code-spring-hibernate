package com.spring.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.exception.UserNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    // handle specific exception
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> userNotFoundException(UserNotFoundException userNotFoundException) {
	CommonErrorResponse error = new CommonErrorResponse(HttpStatus.NOT_FOUND.value(),
		userNotFoundException.getMessage(), System.currentTimeMillis());
	// response 404
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // handle all exception
    @ExceptionHandler
    public ResponseEntity<CommonErrorResponse> commonException(Exception ex) {
	CommonErrorResponse error = new CommonErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
		System.currentTimeMillis());
	System.out.println(ex);
	// response 400
	return new ResponseEntity<CommonErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
