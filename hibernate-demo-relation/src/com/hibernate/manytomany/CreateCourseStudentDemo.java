package com.hibernate.manytomany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseStudentDemo {

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
	    // create object
	    Course course = new Course("Photography Course");

	    // save course️
	    session.save(course);

	    // create object
	    Student student1 = new Student("shoko", "michiga", "shoko@gmail.com");
	    Student student2 = new Student("david", "kim", "david@gmail.com");
	    Student student3 = new Student("mary", "grey", "mary@gmail.com");

	    // add student to course
	    course.setStudents(Arrays.asList(student1, student2, student3));

	    // ❗CASCADE.ALL OFF new object of student have to save
	    System.out.println("[Try to save] ");
	    session.save(student1);
	    session.save(student2);
	    session.save(student3);

	    // OR session.persist(course); -> not guarantee save immediately️

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
