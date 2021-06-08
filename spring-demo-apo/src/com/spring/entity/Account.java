package com.spring.entity;

public class Account {

    private int id;
    private String level;

    public Account() {
    }

    public Account(int id, String level) {
	this.id = id;
	this.level = level;
    }

    public int getId() {
	System.out.println(getClass().getSimpleName() + ": getId()");
	return id;
    }

    public void setId(int id) {
	System.out.println(getClass().getSimpleName() + ": setId()");
	this.id = id;
    }

    public String getLevel() {
	// System.out.println(getClass().getSimpleName() + ": getLevel()");
	return level;
    }

    public void setLevel(String level) {
	// System.out.println(getClass().getSimpleName() + ": setLevel()");
	this.level = level;
    }

    @Override
    public String toString() {
	return "Account [id=" + id + ", level=" + level + "]";
    }

}
