package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.EmployeeDAO;
import com.test.my_spring_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeDAO.getById(id);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return employeeDAO.update(id, employee);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }
}
