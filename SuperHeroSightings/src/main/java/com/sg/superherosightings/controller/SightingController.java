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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Buddy
 */
@Controller
public class SightingController {
    
    @Autowired
    SuperService service;
    
   @GetMapping("/sightings")
    public String displaySightings(Model model) {
        List<Sighting> allSightings = service.getAllSightings();
        List<Hero> allHeroes = service.getAllHeroes();
        List<Location> allLocations = service.getAllLocations();
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("locations", allLocations);
        model.addAttribute("sightings", allSightings);
        return "sightings";
    }
    
    @PostMapping("/addSighting")
    public String addSighting (Sighting newSighting, HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(request.getParameter("dateToParse"), formatter);
        newSighting.setSightingDate(date);
        service.addSighting(newSighting);
        return "redirect:/sightings";
    }
    
    @RequestMapping("/deleteSighting/{id}")
    public String deleteSighting(@PathVariable(name = "id") Integer id) {
        service.deleteSighting(id);
        return "redirect:/sightings";
    }
    
    @RequestMapping("/editSighting/{id}")
    public String editSighting(@PathVariable(name = "id") Integer id, Model model){
        List<Hero> allHeroes = service.getAllHeroes();
        List<Location> allLocations = service.getAllLocations();
        Sighting toEdit = service.getSightingById(id);
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("locations", allLocations);
        model.addAttribute("toEdit", toEdit);
        return "editSighting";
    }
    @PostMapping("/editSighting")
    public String editSighting(Sighting toEdit, HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(request.getParameter("dateToParse"), formatter);
        toEdit.setSightingDate(date);
        service.editSighting(toEdit);
        return "redirect:/sightings";
    }
    
}
