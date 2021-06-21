package com.hibernate.onetomany.uni;

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

    // helper
    public void addReview(Review review) {
	if (reviews == null) {
	    reviews = new ArrayList<>();
	}
	reviews.add(review);
    }

    @Override
    public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
    }

}
