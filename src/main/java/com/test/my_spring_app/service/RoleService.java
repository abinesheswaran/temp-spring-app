package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAll();
    public Role getById(int id);
    public void add(Role role);
    public void update(Role role, int id);
    public void delete(int id);
}
