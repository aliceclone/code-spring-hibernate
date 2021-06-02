package com.hibernate.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

	SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
		.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

	Session session = sessionFactory.getCurrentSession();

	try {

	    // start
	    System.out.println("[beginTransaction]");
	    session.beginTransaction();

	    // process
	    // get course from db
	    int courseId = 5;
	    Course course = session.get(Course.class, courseId);

	    if (course == null) {
		throw new NullPointerException("🔺Course Id not found!");
	    }
	    int instructorId = course.getTheInstructor().getId();
	    System.out.println("[Get Instructor] Id: " + instructorId);
	    System.out.println("[Try to delete] " + course.getTitle());

	    // ❗CASCADE.REMOVE -> off, so instructor should't delete.️
	    session.delete(course);

	    // commit
	    System.out.println("🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻🔺🔻");
	    session.getTransaction().commit();

	    // after delete, check instructor still exist
	    session = sessionFactory.getCurrentSession();
	    session.beginTransaction();

	    // after delete, check instructor still exist
	    Instructor instructor = session.get(Instructor.class, instructorId);
	    System.out.println("[Check Instructor] " + instructor);

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
