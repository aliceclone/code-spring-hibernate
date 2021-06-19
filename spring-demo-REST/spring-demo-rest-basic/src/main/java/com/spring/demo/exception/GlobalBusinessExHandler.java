package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalBusinessExHandler {

    @ExceptionHandler
    public ResponseEntity<?> genericException(Exception ex) {
	System.out.println(getClass().getSimpleName());

	CommonErrResponse error = new CommonErrResponse(HttpStatus.BAD_REQUEST.value(),
		"Sorry cannot perform your request.", System.currentTimeMillis());

	return new ResponseEntity<CommonErrResponse>(error, HttpStatus.BAD_REQUEST);
    }

}
