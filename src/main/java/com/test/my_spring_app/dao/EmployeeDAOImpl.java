package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee getById(Long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee employee) {
        Employee emp = entityManager.find(Employee.class,id);
        emp.setExp(employee.getExp());
        emp.setEmail(employee.getEmail());
        emp.setName(employee.getName());
        emp.setPhno(employee.getPhno());
        emp.setLocation(employee.getLocation());
        emp.setRole(employee.getRole());
        return entityManager.merge(emp);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
