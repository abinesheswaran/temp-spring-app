package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager em;

    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        em.persist(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee, int id) {
        Employee emp = em.find(Employee.class, id);
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setAge(employee.getAge());
        emp.setRoleId(employee.getRoleId());
        emp.setTeamId(employee.getTeamId());
        emp.setVehicleId(employee.getVehicleId());
        em.merge(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Employee.class, id));
    }
}
