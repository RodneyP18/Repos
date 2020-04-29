/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.service.DuplicateInputException;
import com.sg.superherosightings.service.SuperService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
        model.addAttribute("location", new Location());
        model.addAttribute("errors", new ArrayList<>());
        model.addAttribute("locations", allLocations);
        return "locations";
    }

    @PostMapping("/addLocation")
    public String addLocation(@Valid Location newLocation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Location> locations = service.getAllLocations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("location", newLocation);
            model.addAttribute("locations", locations);

            return "locations";
        }
        try {
            service.addLocation(newLocation);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("location", "locationName", "Name already exists.");
            result.addError(error);
            List<Location> locations = service.getAllLocations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("location", newLocation);
            model.addAttribute("locations", locations);
            return "locations";
        }

        return "redirect:/locations";
    }

    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable(name = "id") Integer id) {
        service.deleteLocation(id);
        return "redirect:/locations";
    }

    @RequestMapping("/editLocation/{id}")
    public String editLocation(@PathVariable(name = "id") Integer id, Model model) {
        Location toEdit = service.getLocationById(id);
        model.addAttribute("toEdit", toEdit);
        return "editLocation";
    }

    @PostMapping("/editLocation")
    public String editLocation(@Valid Location toEdit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Location> allLocations = service.getAllLocations();
            model.addAttribute("toEdit", toEdit);
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("locations", allLocations);
            return "editLocation";
        }
        try {
            service.editLocation(toEdit);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("location", "locationName", "Name already exists.");
            result.addError(error);
            List<Location> allLocations = service.getAllLocations();
            model.addAttribute("toEdit", toEdit);
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("locations", allLocations);
            return "editLocation";
        }

        return "redirect:/locations";
    }
}
