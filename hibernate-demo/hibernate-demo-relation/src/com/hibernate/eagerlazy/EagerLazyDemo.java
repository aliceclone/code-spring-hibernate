package com.hibernate.eagerlazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.eagerlazy.lazy.CourseLazy;
import com.hibernate.eagerlazy.lazy.InstructorDetailLazy;
import com.hibernate.eagerlazy.lazy.InstructorLazy;

public class EagerLazyDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(InstructorLazy.class)
		.addAnnotatedClass(InstructorDetailLazy.class).addAnnotatedClass(CourseLazy.class)
		.buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    int instructorId = 1;
	    InstructorLazy instructor = session.get(InstructorLazy.class, instructorId);
	    // test eager and lazy
	    System.out.println("[Get Instructor] " + instructor);
	    System.out.println("πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»");

	    System.out.println("β as LAZY FETCH, Course will fetch by separated sql");
	    System.out.println("[Get Instructor of Course] " + instructor.getCourses());

	    // commit
	    session.getTransaction().commit();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    // close
	    session.close();
	    sessionFactory.close();
	}
    }

}
