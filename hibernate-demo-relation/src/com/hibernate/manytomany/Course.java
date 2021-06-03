package com.hibernate.manytomany;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    public Course() {
    }

    public Course(String title) {
	this.title = title;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    // ❗
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "instructor_id")
    private Instructor theInstructor;

    // ❗uni-directional with review
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    // ❗join Table [course_student], no extra entity use
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	    CascadeType.REFRESH })
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    // ❗Bi directional
    public Instructor getTheInstructor() {
	return theInstructor;
    }

    public void setTheInstructor(Instructor theInstructor) {
	this.theInstructor = theInstructor;
    }

    public List<Review> getReviews() {
	return reviews;
    }

    public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
    }

    public List<Student> getStudents() {
	return students;
    }

    public void setStudents(List<Student> students) {
	this.students = students;
    }

    // helper
    public void addReview(Review review) {
	if (reviews == null) {
	    reviews = new ArrayList<>();
	}
	reviews.add(review);
    }

    public void addStudent(Student student) {
	if (students == null) {
	    students = new ArrayList<>();
	}
	students.add(student);

    }

    @Override
    public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
    }

}
