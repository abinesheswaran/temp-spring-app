package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(int id);
    public void add(Employee employee);
    public void update(Employee employee, int id);
    public void delete(int id);
}
