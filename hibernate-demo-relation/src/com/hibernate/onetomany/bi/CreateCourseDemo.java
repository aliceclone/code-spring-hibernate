package com.hibernate.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // create object
	    Course course1 = new Course("Spring Security Course");

	    // get instructor from db
	    int instructorId = 2;
	    Instructor instructor = session.get(Instructor.class, instructorId);

	    // add
	    if (instructor != null) {
		instructor.addCourse(course1);

		System.out.println("[Try to save] " + instructor);
		// ❗️
		// session.persist(instructor); -> save all course ok
		// or
		session.save(course1);
		// or
		// session.save(instructor);

		// commit
		System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
		session.getTransaction().commit();
		// ❗after commit instructor cannot print
		// System.out.println("[Save] " + instructor);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    // close
	    session.close();
	    sessionFactory.close();
	}
    }

}
