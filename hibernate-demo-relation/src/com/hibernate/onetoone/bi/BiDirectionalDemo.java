package com.hibernate.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {
	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // get instructor detail
	    int instructorDetailId = 2;
	    InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
	    System.out.println("[get] instructorDetail" + instructorDetail);

	    if (instructorDetail != null) {
		// 🤯 get instructor from instructior detail
		Instructor instructor = instructorDetail.getInstructor();
		System.out.println("[get] instructor " + instructor);
	    }

	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");

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
