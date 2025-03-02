package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;
    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public void add(Employee employee) {
        em.persist(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    @Override
    public List<Employee> getAll() {
        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        Employee theEmployee = em.find(Employee.class,id);
        theEmployee.setName(employee.getName());
        theEmployee.setAge(employee.getAge());
        em.merge(theEmployee);
    }
}
