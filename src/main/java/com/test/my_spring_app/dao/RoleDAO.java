package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Role;

import java.util.List;

public interface RoleDAO {

    public Role getById(int id);

    public List<Role> getAll();

    public void add(Role role);

    public void update(Role role, int id);

    public void delete(int id);
}
