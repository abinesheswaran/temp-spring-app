package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {
    private EntityManager em;

    @Autowired
    public TeamDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void add(Team team) {
        em.persist(team);
    }

    @Override
    @Transactional
    public void update(Team team, int id) {
        Team theTeam = em.find(Team.class, id);
        theTeam.setName(team.getName());
        theTeam.setDirectorId(team.getDirectorId());
        theTeam.setProjectName(team.getProjectName());
        theTeam.setEmployees(team.getEmployees());
        em.merge(theTeam);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(em.find(Team.class, id));
    }

    @Override
    public Team getById(int id) {
        return em.find(Team.class, id);
    }

    @Override
    public List<Team> getAll() {
        return em.createQuery("from Team", Team.class).getResultList();
    }
}
