package com.hibernate.eagerlazy.lazy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class InstructorLazy {

    public InstructorLazy() {
    }

    public InstructorLazy(String firstName, String lastName, String email) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetailLazy instructorDetail;

    // One to Many, FetchType.LAZY
    // ❗FetchType.EAGER will left outer join course from begining
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "theInstructor", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
	    CascadeType.DETACH, CascadeType.REFRESH })
    private List<CourseLazy> courses = new ArrayList<>();

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public InstructorDetailLazy getInstructorDetail() {
	return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetailLazy instructorDetail) {
	this.instructorDetail = instructorDetail;
    }

    public List<CourseLazy> getCourses() {
	return courses;
    }

    public void setCourses(List<CourseLazy> courses) {
	this.courses = courses;
    }

    // 🤝
    public void addCourse(CourseLazy course) {
	if (courses == null) {
	    courses = new ArrayList<>();
	}
	courses.add(course);
	// ❗association
	course.setTheInstructor(this);
    }

    // toString() on [courses] will trigger select on course even LAZY is ON

//    @Override
//    public String toString() {
//	return "InstructorLazy [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//		+ ", instructorDetail=" + instructorDetail + ", courses=" + courses + "]";
//    }

}
