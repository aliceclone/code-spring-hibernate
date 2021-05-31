package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudent {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
		.buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	try {
	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    Student student = new Student("yamada", "koku", "yamada@hibernate.com");
	    System.out.println("[Saving]....");
	    session.save(student);

	    // commit the transaction, it will close the session as well!!
	    System.out.println("[commiting]");
	    session.getTransaction().commit();
	    System.out.println("[Saved] " + student);
	    System.out.println("[Saved] Id: " + student.getId());

	    // ---- read ----

	    // create new session
	    session = sessionFactory.getCurrentSession();
	    // start
	    session.beginTransaction();

	    // get student by primary key
	    Student readStudent = session.get(Student.class, student.getId());
	    System.out.println("[Retrieve] by " + student.getId() + "\n" + readStudent);

	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	} catch (Exception e) {
	    e.printStackTrace();

	} finally {

	    System.out.println("[closing]");
	    session.close();
	    System.out.println("[Done]");
	}
    }

}
