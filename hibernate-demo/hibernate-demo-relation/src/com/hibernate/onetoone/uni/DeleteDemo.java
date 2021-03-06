package com.hibernate.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {
	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // get
	    int instructorId = 1;
	    Instructor instructor = session.get(Instructor.class, instructorId);
	    System.out.println("[get] " + instructor);
	    if (instructor != null) {
		// delete
		// ð¤¯ CASCADE will delete InstructorDetail too
		// âHQL statement won't work with CASCADEï¸
		System.out.println("[deleting] " + instructor);
		session.delete(instructor);
	    }

	    System.out.println("ðºð»ðºð»ðºð»ðºð»ðºð»ðºð»ðºð»ðºð»");

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	} finally {
	    // close
	    System.out.println("[closing]");
	    session.close();
	    sessionFactory.close();
	}
    }

}
