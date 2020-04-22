/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Sighting;
import com.sg.superherosightings.service.SuperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Buddy
 */
@Controller
public class MainController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("")
    public String displayHome(Model model) {
       
        List<Sighting> allSightings = service.getRecentSightings();
        List<Hero> allHeroes = service.getAllHeroes();
        List<Location> allLocations = service.getAllLocations();
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("locations", allLocations);
        model.addAttribute("sightings", allSightings);
        return "index";
    }
    
    @GetMapping("/index")
    public String homePage(Model model) {
        
        List<Sighting> allSightings = service.getRecentSightings();
        List<Hero> allHeroes = service.getAllHeroes();
        List<Location> allLocations = service.getAllLocations();
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("locations", allLocations);
        model.addAttribute("sightings", allSightings);
        return "index";
    }
    
}
