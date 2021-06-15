package com.spring.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Student;
import com.spring.demo.exception.BusinessException;
import com.spring.demo.exception.CommonErrResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadStudents() {

	if (students == null) {
	    students = new ArrayList<>();

	    students.add(new Student("Susan", "Smith"));
	    students.add(new Student("John", "Doe"));
	    students.add(new Student("Mary", "Flower"));
	}

    }

    @GetMapping("/students")
    public List<Student> getStudents() {

	return students;
    }

    // ❗️@PathVariable("id") int theId will result:
    // 0000 -> 0
    // 01 -> 1
    // 00001 -> 1
    // 000012 -> 12
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {

	if (id >= students.size() || id < 0) {
	    throw new BusinessException("Student " + id + " not found.");
	}

	return students.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<CommonErrResponse> studentNotFoundException(BusinessException ex) {

	CommonErrResponse error = new CommonErrResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
		System.currentTimeMillis());

	return new ResponseEntity<CommonErrResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> genericException(Exception ex) {
	CommonErrResponse error = new CommonErrResponse(HttpStatus.BAD_REQUEST.value(),
		"Sorry cannot perform your request.", System.currentTimeMillis());

	return new ResponseEntity<CommonErrResponse>(error, HttpStatus.BAD_REQUEST);
    }

}
