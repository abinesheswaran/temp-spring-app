package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private EntityManager em;
    @Autowired
    public RoleDAOImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Role getById(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    @Transactional
    public void add(Role role) {
        em.persist(role);
    }

    @Override
    @Transactional
    public void update(Role role, int id) {
        Role theRole = em.find(Role.class, id);
        theRole.setName(role.getName());
        theRole.setMaxSalary(role.getMaxSalary());
        theRole.setMinSalary(role.getMinSalary());
        theRole.setLevel(role.getLevel());
        em.merge(theRole);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Role.class, id));
    }
}
