package com.spring.demo.dao;

import com.spring.demo.entity.User;

public interface UserDao {

    public User findbyUserId(Long id);

    public User findbyUserName(String name);

    public void saveOrUpdate(User user);
}
