package com.hibernate.onetoone.uni;

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
	    Instructor instructor = new Instructor("mono", "polo", "mono@gmail.com");

	    InstructorDetail instructorDetail = new InstructorDetail("mono@youtube.com", "Photography");

	    // associate
	    instructor.setInstructorDetail(instructorDetail);

	    // save
	    // π€― CASCADE will save InstructorDetail too
	    System.out.println("[save] " + instructor);
	    session.save(instructor);
	    // βWithout CASCADE.ALL, need to save
	    // session.persist(instructor);
	    System.out.println("πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»πΊπ»");

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
