package com.spring.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findbyUserId(Long id) {
	Session session = sessionFactory.getCurrentSession();

	// fetch user
	Query<User> query = session.createQuery("from User where id=:theId", User.class);
	query.setParameter("theId", id);
	// get single record
	User user = query.getSingleResult();

	return user;
    }

    @Override
    public User findbyUserName(String name) {
	Session session = sessionFactory.getCurrentSession();

	// fetch user
	Query<User> query = session.createQuery("from User where username=:theName", User.class);
	query.setParameter("theName", name);
	// get single record
	User user = query.getSingleResult();

	return user;
    }

    @Override
    public void saveOrUpdate(User user) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(user);
    }

    @Override
    public List<User> getUsers() {
	Session session = sessionFactory.getCurrentSession();
	Query<User> query = session.createQuery("from User order by lastName", User.class);
	return query.getResultList();
    }

    @Override
    public void deleteUser(Long id) {
	Session session = sessionFactory.getCurrentSession();
	Query query = session.createQuery("delete from User where id=:theId");
	query.setParameter("theId", id);
	query.executeUpdate();
    }

}
