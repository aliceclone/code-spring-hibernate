package com.hibernate.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {
	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // create object
	    Instructor instructor = new Instructor("kiwi", "qartar", "kiwi@gmail.com");

	    InstructorDetail instructorDetail = new InstructorDetail("kiwi@youtube.com", "Reading");
	    // associate
	    instructor.setInstructorDetail(instructorDetail);

	    // save
	    // 🤯 CASCADE.ALL will save instructorDetail too
	    System.out.println("[save] " + instructor);
	    session.save(instructor);

	    // commit
	    System.out.println("[commiting] 🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
	    session.getTransaction().commit();

	} finally {
	    // close
	    System.out.println("[closing]");
	    session.close();
	    sessionFactory.close();
	}
    }

}
