package com.test.my_spring_app.service;

import com.test.my_spring_app.dao.TeamDAO;
import com.test.my_spring_app.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamDAO teamDAO;
    @Autowired
    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
    @Override
    public Team getById(int id) {
        return teamDAO.getById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamDAO.getAll();
    }

    @Override
    public void add(Team team) {
        teamDAO.add(team);
    }

    @Override
    public void update(Team team, int id) {
        teamDAO.update(team, id);
    }

    @Override
    public void delete(int id) {
        teamDAO.delete(id);
    }
}
