package com.test.my_spring_app.controller;

import com.test.my_spring_app.entity.Team;
import com.test.my_spring_app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/team")
@RestController
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    public List<Team> getAllTeam() {
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id) {
        return teamService.getById(id);
    }

    @PostMapping()
    public void addTeam(@RequestBody Team team) {
        teamService.add(team);
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable int id, @RequestBody Team team) {
        teamService.update(team, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamService.delete(id);
    }
}
