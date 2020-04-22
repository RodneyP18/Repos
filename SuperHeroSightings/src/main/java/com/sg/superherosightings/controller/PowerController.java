/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
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
public class PowerController {

    @Autowired
    SuperService service;

    @GetMapping("/powers")
    public String displayPowers(Model model) {
        List<Power> allPowers = service.getAllPowers();
        model.addAttribute("powers", allPowers);
        return "powers";
    }
    
    @PostMapping("/addPower")
    public String addPower (Power newPower){
        service.addPower(newPower);
        return "redirect:/powers";
    }
    
    @RequestMapping("/deletePower/{id}")
    public String deletePower(@PathVariable(name = "id") Integer id) {
        service.deletePower(id);
        return "redirect:/powers";
    }
    
    @RequestMapping("/editPower/{id}")
    public String editPower(@PathVariable(name = "id") Integer id, Model model){
        Power toEdit = service.getPowerById(id);
        model.addAttribute("toEdit", toEdit);
        return "editPower";
    }
    @PostMapping("/editPower")
    public String editPower(Power toEdit){
        service.editPower(toEdit);
        return "redirect:/powers";
    }
}
