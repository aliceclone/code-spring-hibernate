package com.spring.demo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    private long timeStamp;

    public ApiError(HttpStatus status, String message, List<String> errors, long timeStamp) {
	this.status = status;
	this.message = message;
	this.errors = errors;
	this.timeStamp = timeStamp;
    }

    public ApiError(HttpStatus status, String message, String error, long timeStamp) {
	this.status = status;
	this.message = message;
	this.errors = Arrays.asList(error);
	this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
	return status;
    }

    public void setStatus(HttpStatus status) {
	this.status = status;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public List<String> getErrors() {
	return errors;
    }

    public void setErrors(List<String> errors) {
	this.errors = errors;
    }

    public long getTimeStamp() {
	return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
	this.timeStamp = timeStamp;
    }

}