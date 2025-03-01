package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.EmployeeRoleDAO;
import com.test.my_spring_app.entity.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService{
    private EmployeeRoleDAO employeeRoleDAO;
    @Autowired
    public void setEmployeeRoleDAO(EmployeeRoleDAO employeeRoleDAO) {
        this.employeeRoleDAO = employeeRoleDAO;
    }
    @Override
    public List<EmployeeRole> getAll() {
        return employeeRoleDAO.getAll();
    }

    @Override
    public EmployeeRole getById(int id) {
        return employeeRoleDAO.getById(id);
    }

    @Override
    public EmployeeRole getEmployeeRoleByEmployeeId(int employeeId) {
        return employeeRoleDAO.getEmployeeRoleByEmployeeId(employeeId);
    }

    @Override
    public void add(EmployeeRole employeeRole) {
        employeeRoleDAO.add(employeeRole);
    }

    @Override
    public void update(EmployeeRole employeeRole, int employeeId) {
        employeeRoleDAO.update(employeeRole, employeeId);
    }

    @Override
    public void delete(int id) {
        employeeRoleDAO.delete(id);
    }
}
