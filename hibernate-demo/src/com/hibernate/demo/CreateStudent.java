package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudent {

    public static void main(String[] args) {

	// session factory
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
	// session
	Session session = sessionFactory.getCurrentSession();

	try {
	    // create obj
	    System.out.println("[Creating]...");
	    Student student = new Student("Applo", "Doe", "applo@hibernate.com");

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // save
	    System.out.println("[Saving]....");
	    session.save(student);

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();
	    System.out.println("[Saved] " + student);

	} finally {
	    System.out.println("[closing]");
	    sessionFactory.close();
	}

    }

}
