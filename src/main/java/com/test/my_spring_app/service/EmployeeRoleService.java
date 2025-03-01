package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.EmployeeRole;

import java.util.List;

public interface EmployeeRoleService {
    public List<EmployeeRole> getAll();
    public EmployeeRole getById(int id);
    public EmployeeRole getEmployeeRoleByEmployeeId(int employeeId);
    public void add(EmployeeRole employeeRole);
    public void update(EmployeeRole employeeRole, int employeeId);
    public void delete(int id);
}
