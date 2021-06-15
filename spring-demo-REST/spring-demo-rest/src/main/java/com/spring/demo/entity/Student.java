package com.spring.demo.entity;

public class Student {

    // private int id;
    private String firstName;
    private String lastName;
    // private boolean active;
    // private Address address;
    // private String[] skills;

    public Student(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}
