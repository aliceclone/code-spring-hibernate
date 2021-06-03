package com.hibernate.eagerlazy.lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseLazy {

    public CourseLazy() {
    }

    public CourseLazy(String title) {
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
    private InstructorLazy theInstructor;

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
    public InstructorLazy getTheInstructor() {
	return theInstructor;
    }

    public void setTheInstructor(InstructorLazy theInstructor) {
	this.theInstructor = theInstructor;
    }

    @Override
    public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
    }

}
