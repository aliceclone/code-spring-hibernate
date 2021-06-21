package com.hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudent {

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

	    // way 1: delete by query
	    int studentId = 1;
	    String query = String.format("delete from Student s where s.id='%s'", studentId);
	    System.out.println("[delete] by student id: " + studentId);
	    int result = session.createQuery(query).executeUpdate();
	    System.out.println(result);
	    System.out.println("◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");

	    // commit
	    System.out.println("[commiting]");
	    session.getTransaction().commit();
	    System.out.println("◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼◼");

	    session = sessionFactory.getCurrentSession();
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // way 2: delete by object
	    System.out.println("[delete] by student id: " + 2);
	    Student toDel = session.get(Student.class, 2);
	    if (toDel != null) {

		session.delete(toDel);
	    }

	    System.out.println("[commiting]");
	    session.getTransaction().commit();

	} finally {
	    System.out.println("[closing]");
	    sessionFactory.close();
	}

    }

}
