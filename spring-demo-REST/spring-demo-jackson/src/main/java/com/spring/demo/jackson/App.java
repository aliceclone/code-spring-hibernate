package com.spring.demo.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) {

	ObjectMapper objectMapper = new ObjectMapper();
	try {
	    // read
	    Student student = objectMapper.readValue(new File("json/student_address.json"), Student.class);

	    System.out.println("FirstName: " + student.getFirstName() + " | LastName: " + student.getLastName());
	    System.out.println("Active: " + student.isActive());
	    System.out.println("Address: " + student.getAddress().getCity());

	    System.out.println("Skills:");
	    for (String skill : student.getSkills()) {
		System.out.println(skill);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
