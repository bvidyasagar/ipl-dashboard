package com.sagar.ipl_dashboard.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sagar.ipl_dashboard.model.Team;
import com.sagar.ipl_dashboard.service.TeamService;


@RestController
public class TeamController {

    @Autowired
    private TeamService teamService; 

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        return teamService.findTeamName(teamName);
    }
    
}