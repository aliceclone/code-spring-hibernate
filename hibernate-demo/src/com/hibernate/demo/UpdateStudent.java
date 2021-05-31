package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudent {

    public static void main(String[] args) {

	// session factory
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class).buildSessionFactory();
	// session
	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // get
	    int studentId = 1;
	    Student student = session.get(Student.class, studentId);
	    System.out.println("[read] by student id: " + studentId);
	    System.out.println("[read] : " + student);
	    System.out.println("◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");

	    // way 1: update simple
	    System.out.println("[update]");
	    student.setLastName("eclipse");
	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	    System.out.println("◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");

	    session = sessionFactory.getCurrentSession();
	    session.beginTransaction();

	    // way: 2 update with query
	    String query = String.format("update Student s set s.firstName ='paul' where s.id='%s'", studentId);
	    session.createQuery(query).executeUpdate();

	    // way 3 update only single object
//	    student.setFirstName("luna");
//	    session.update(student);

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	} finally {
	    System.out.println("[closing]");
	    sessionFactory.close();
	}

    }

}
