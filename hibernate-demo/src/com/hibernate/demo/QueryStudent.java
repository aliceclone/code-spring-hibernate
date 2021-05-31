package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudent {

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

	    // query
	    System.out.println("[Query]....");
	    List<Student> students = session.createQuery("from Student", Student.class).getResultList();

	    print(students);

	    System.out.println("[Query] by first name or last name");

	    students = session
		    .createQuery("from Student s where s.firstName = 'kim' OR s.lastName='koku'", Student.class)
		    .getResultList();

	    print(students);

	    System.out.println("[Query] by LIKE");

	    students = session.createQuery("from Student s where s.email LIKE '%spring.com'", Student.class)
		    .getResultList();

	    print(students);

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	} finally {
	    System.out.println("[closing]");
	    sessionFactory.close();
	}

    }

    private static void print(List<Student> students) {
	for (Student student : students) {
	    System.out.println(student + "\n");
	}
	System.out.println("◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");
    }

}
