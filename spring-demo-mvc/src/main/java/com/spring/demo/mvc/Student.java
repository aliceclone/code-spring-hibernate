package com.spring.demo.mvc;

import java.util.HashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	private String countryA;
	private String countryB;

	private Map<String, String> countryOptionsA;

	private String favoriteLanguage;

	public Student() {
		countryOptionsA = new HashMap<>();
		countryOptionsA.put("AR", "Argentina");
		countryOptionsA.put("BE", "Belgium");
		countryOptionsA.put("CR", "Costa Rica");
		countryOptionsA.put("DK", "Denmark");
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

	public Map<String, String> getCountryOptionsA() {
		return countryOptionsA;
	}

	public String getCountryA() {
		return countryA;
	}

	public void setCountryA(String countryA) {
		this.countryA = countryA;
	}

	public String getCountryB() {
		return countryB;
	}

	public void setCountryB(String countryB) {
		this.countryB = countryB;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

}
