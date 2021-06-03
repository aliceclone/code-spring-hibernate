package com.hibernate.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    int instructorId = 1;
	    Instructor instructor = session.get(Instructor.class, instructorId);
	    // test eager and lazy
	    System.out.println("[Get Instructor] " + instructor);
	    // Hibernate.isInitialized(args);

	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
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
