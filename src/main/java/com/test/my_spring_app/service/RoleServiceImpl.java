package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.RoleDAO;
import com.test.my_spring_app.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleDAO roleDAO;
    @Autowired
    public void setRoleDao(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    @Override
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public Role getById(int id) {
        return roleDAO.getById(id);
    }

    @Override
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    public void update(Role role, int id) {
        roleDAO.update(role, id);
    }

    @Override
    public void delete(int id) {
        roleDAO.delete(id);
    }
}
