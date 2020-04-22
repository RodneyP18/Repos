/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.service.SuperService;
import java.util.List;
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
public class LocationController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("/locations")
    public String displayLocations(Model model) {
        List<Location> allLocations = service.getAllLocations();
        model.addAttribute("locations", allLocations);
        return "locations";
    }
    
    @PostMapping("/addLocation")
    public String addLocation (Location newLocation){
        service.addLocation(newLocation);
        return "redirect:/locations";
    }
    
    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable(name = "id") Integer id) {
        service.deleteLocation(id);
        return "redirect:/locations";
    }
    
    @RequestMapping("/editLocation/{id}")
    public String editLocation(@PathVariable(name = "id") Integer id, Model model){
        Location toEdit = service.getLocationById(id);
        model.addAttribute("toEdit", toEdit);
        return "editLocation";
    }
    @PostMapping("/editLocation")
    public String editLocation(Location toEdit){
        service.editLocation(toEdit);
        return "redirect:/locations";
    }
}
