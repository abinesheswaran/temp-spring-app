package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.EmployeeRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRoleDAOImpl implements EmployeeRoleDAO {
    private EntityManager em;

    @Autowired
    public EmployeeRoleDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<EmployeeRole> getAll() {
        TypedQuery<EmployeeRole> query = em.createQuery("from EmployeeRole", EmployeeRole.class);
        return query.getResultList();
    }

    @Override
    public EmployeeRole getById(int id) {
        return em.find(EmployeeRole.class, id);
    }

    @Override
    public EmployeeRole getEmployeeRoleByEmployeeId(int employeeId) {
        return em.find(EmployeeRole.class, employeeId);
    }

    @Override
    @Transactional
    public void add(EmployeeRole employeeRole) {
        em.persist(employeeRole);
    }

    @Override
    @Transactional
    public void update(EmployeeRole employeeRole, int id) {
        EmployeeRole empRole = em.find(EmployeeRole.class, id);
        empRole.setEmployeeId(employeeRole.getEmployeeId());
        empRole.setRoleId(employeeRole.getRoleId());
        em.merge(empRole);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(EmployeeRole.class, id));
    }
}
