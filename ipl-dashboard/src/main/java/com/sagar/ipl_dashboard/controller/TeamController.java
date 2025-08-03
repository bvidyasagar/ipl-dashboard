package com.sagar.ipl_dashboard.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sagar.ipl_dashboard.model.Team;
import com.sagar.ipl_dashboard.repository.MatchRepository;
import com.sagar.ipl_dashboard.service.TeamService;


@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamService teamService; 
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamService.findTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
        return team;
    }

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return teamService.findAllTeams();
    }
    
}