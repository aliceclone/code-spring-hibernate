package com.hibernate.eagerlazy.lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailLazy {

    public InstructorDetailLazy() {
    }

    public InstructorDetailLazy(String youtubeChannel, String hobby) {
	this.youtubeChannel = youtubeChannel;
	this.hobby = hobby;
    }

    // ignore remove, when delete only delete detail
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private InstructorLazy instructor;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getYoutubeChannel() {
	return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
	this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
	return hobby;
    }

    public void setHobby(String hobby) {
	this.hobby = hobby;
    }

    public InstructorLazy getInstructor() {
	return instructor;
    }

    // ❗Bi directional
    public void setInstructor(InstructorLazy instructor) {
	this.instructor = instructor;
    }

    @Override
    public String toString() {
	return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
    }

}
