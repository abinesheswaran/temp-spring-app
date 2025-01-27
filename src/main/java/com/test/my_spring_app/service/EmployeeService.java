package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void create(Employee employee);

    public List<Employee> getAll();

    public Employee getById(Long id);

    public Employee update(Long id, Employee employee);

    public void delete(Long id);
}
