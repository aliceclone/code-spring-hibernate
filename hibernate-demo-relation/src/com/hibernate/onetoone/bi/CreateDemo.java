package com.hibernate.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {
	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process

	    // create object
	    Instructor instructor = new Instructor("paul", "schol", "paul@gmail.com");

	    InstructorDetail instructorDetail = new InstructorDetail("paul@youtube.com", "Cooking");

	    // associate
	    instructor.setInstructorDetail(instructorDetail);

	    // save
	    // 🤯 CASCADE will save InstructorDetail too
	    System.out.println("[save] " + instructor);
	    session.save(instructor);
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
