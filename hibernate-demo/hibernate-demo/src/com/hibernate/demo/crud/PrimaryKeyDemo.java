package com.hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

	// session factory
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
	// session
	Session session = sessionFactory.getCurrentSession();

	try {
	    // create multiple object
	    System.out.println("[Creating]...");
	    Student student1 = new Student("Paul", "Schol", "schol@hibernate.com");
	    Student student2 = new Student("Kim", "yuri", "yuri@hibernate.com");
	    Student student3 = new Student("Tanaka", "satoru", "tanaka@hibernate.com");
	    // Student[] studentArray = { student1, student2, student3 };

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // save
	    System.out.println("[Saving]....");
	    session.save(student1);
	    session.save(student2);
	    session.save(student3);

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();
	    System.out.println("[Saved] " + student1);
	    System.out.println("[Saved] " + student2);
	    System.out.println("[Saved] " + student3);

	} catch (Exception e) {
	    System.out.println("[Fail]");
	    e.printStackTrace();
	} finally {
	    System.out.println("[closing]");
	    sessionFactory.close();
	    System.out.println("[Done]");
	}

    }

}

// DELETE all data TESTING PURPOSE!!
//truncate hb_student_tracker.student;
