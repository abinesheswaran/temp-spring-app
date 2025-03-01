package com.test.my_spring_app.dao;

import com.test.my_spring_app.entity.Team;

import java.util.List;

public interface TeamDAO {
    public void add(Team team);

    public void update(Team team, int id);

    public void delete(int id);

    public Team getById(int id);

    public List<Team> getAll();
}
