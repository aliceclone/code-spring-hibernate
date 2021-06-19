package com.spring.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.demo.entity.User;

public interface UserService extends UserDetailsService {

    public User findbyUserId(Long id);

    public User findbyUserName(String name);

    public List<User> getUsers();

    public void saveOrUpdate(User user);

    public void deleteUser(Long id);

}
