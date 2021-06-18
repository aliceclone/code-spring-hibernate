package com.spring.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.demo.entity.User;

public interface UserService extends UserDetailsService {

    public User findbyUserId(Long id);

    public User findbyUserName(String name);

    public void saveOrUpdate(User user);
}
