package com.spring.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findbyName(String roleName) {
	Session session = sessionFactory.getCurrentSession();
	// create query
	Query<Role> query = session.createQuery("From Role where name=:roleName", Role.class);
	query.setParameter("roleName", roleName);

	// get single hit
	Role role = query.getSingleResult();
	return role;
    }

}
