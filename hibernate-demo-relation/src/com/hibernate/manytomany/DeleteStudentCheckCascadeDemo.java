package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentCheckCascadeDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class)
		.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // get student
	    int studentId = 6;
	    Student student = session.get(Student.class, studentId);
	    System.out.println(student.getCourses());

	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
	    session.delete(student);

	    // commit
	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
	    session.getTransaction().commit();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    // close
	    session.close();
	    sessionFactory.close();
	}
    }

}
