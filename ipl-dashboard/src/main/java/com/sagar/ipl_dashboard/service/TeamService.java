package com.sagar.ipl_dashboard.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.ipl_dashboard.repository.TeamRepository;
import com.sagar.ipl_dashboard.model.Team;

@Service
public class TeamService {
    
    @Autowired TeamRepository teamRepository;

    public Team findTeamName(String teamName) {
        return this.teamRepository.findByTeamName(teamName);
    }

    public Team save(Team team) {
        return this.teamRepository.save(team);
    }

    public Iterable<Team> findAllTeams() {
        return this.teamRepository.findAll();
    }
}