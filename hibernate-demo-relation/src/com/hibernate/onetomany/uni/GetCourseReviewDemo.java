package com.hibernate.onetomany.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseReviewDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
		.addAnnotatedClass(Review.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // get course
	    int courseId = 8;
	    Course course = session.get(Course.class, courseId);

	    System.out.println("[Course] " + course);
	    // ❗ as LAZY FETCH, review will fetch by separated sql
	    System.out.println("[Review] " + course.getReviews());

	    // commit
	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
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
