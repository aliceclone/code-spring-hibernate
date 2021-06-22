package com.spring.demo.dao;

import com.spring.demo.entity.Role;

public interface RoleDao {

    // public Role findbyId(Long id);

    public Role findbyName(String roleName);
}
