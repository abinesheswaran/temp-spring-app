package com.test.my_spring_app.service;

import com.test.my_spring_app.entity.Team;

import java.util.List;

public interface TeamService {
    public Team getById(int id);

    public List<Team> getAll();

    public void add(Team team);

    public void update(Team team, int id);

    public void delete(int id);
}
