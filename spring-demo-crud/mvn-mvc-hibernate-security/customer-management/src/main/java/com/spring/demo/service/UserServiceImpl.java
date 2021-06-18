package com.spring.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.dao.UserDao;
import com.spring.demo.entity.Role;
import com.spring.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	// fetch from db
	User user = userDao.findbyUserName(username);

	// map Role to SimpleGrantedAuthority
	List<SimpleGrantedAuthority> grantedAuth = mapRoleToAuthority(user);
	// create spring security user detail
	return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
		grantedAuth);
    }

    private List<SimpleGrantedAuthority> mapRoleToAuthority(User user) {
	// new SimpleAttributes2GrantedAuthoritiesMapper();
	// get role
	List<Role> roles = user.getRoles();
	List<SimpleGrantedAuthority> grantedRoles = roles.stream().map(r -> new SimpleGrantedAuthority(r.getName()))
		.collect(Collectors.toList());
	return grantedRoles;
    }

    @Override
    @Transactional
    public User findbyUserId(Long id) {
	return userDao.findbyUserId(id);
    }

    @Override
    @Transactional
    public User findbyUserName(String name) {
	return userDao.findbyUserName(name);
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
	userDao.saveOrUpdate(user);
    }

}
