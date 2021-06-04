
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
	    // Student student = new Student("Applo", "Doe", "applo@hibernate.com");

	    // start
	    session.beginTransaction();

	    // save
	    // session.save(student);

	    // commit
	    session.getTransaction().commit();

	} finally {
	    session.close();
	    sessionFactory.close();
	}

    }

}
