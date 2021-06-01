package com.hibernate.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBiDirectionalDemo {

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
	    int instructorDetailId = 3;
	    InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
	    System.out.println("[get] instructorDetail" + instructorDetail);

	    if (instructorDetail != null) {
		// 🤯 delete instructor detail will also instructor deleted CASCADE
		System.out.println("[delete]  ");
		// ❗Without CASCADE.ALL, need to remove deleted object from associations
		instructorDetail.getInstructor().setInstructorDetail(null);

		session.delete(instructorDetail);

	    } else {
		System.out.println("[delete] No Instructor Detail Found ");
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
