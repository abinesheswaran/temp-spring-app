package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public void add(Employee employee);
    public void delete(int id);
    public List<Employee> getAll();
    public Employee getById(int id);
    public void update(Employee employee,int id);
}
