package com.hibernate.onetomany.uni;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateReviewDemo {

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
	    // create object
	    Review review1 = new Review("Wow! Amazing Ever!");
	    Review review2 = new Review("Best!");
	    Review review3 = new Review("Life Saving!");

	    // get course
	    int courseId = 1;
	    Course course = session.get(Course.class, courseId);
	    // add review
	    course.setReviews(Arrays.asList(review1, review2, review3));

	    System.out.println("[Try to save] ");
	    // ❗️
	    session.save(course);

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
