/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.service.DuplicateInputException;
import com.sg.superherosightings.service.NullInputException;
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
public class PowerController {

    @Autowired
    SuperService service;

    @GetMapping("/powers")
    public String displayPowers(Model model) {
        List<Power> allPowers = service.getAllPowers();
        model.addAttribute("errors", new ArrayList<>());
        model.addAttribute("powers", allPowers);
        return "powers";
    }

    @PostMapping("/addPower")
    public String addPower(@Valid Power newPower, BindingResult result, Model model) throws NullInputException {
        if (result.hasErrors()) {
            List<Power> powers = service.getAllPowers();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("power", newPower);
            model.addAttribute("powers", powers);
            
            return "powers";
        }
        try {
            service.addPower(newPower);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("power", "superPower", "Name already exists.");
            result.addError(error);
            return "powers";
        }
        
        return "redirect:/powers";
    }

    @RequestMapping("/deletePower/{id}")
    public String deletePower(@PathVariable(name = "id") Integer id) {
        service.deletePower(id);
        return "redirect:/powers";
    }

    @RequestMapping("/editPower/{id}")
    public String editPower(@PathVariable(name = "id") Integer id, Model model) {
        Power toEdit = service.getPowerById(id);
        model.addAttribute("toEdit", toEdit);
        return "editPower";
    }

    @PostMapping("/editPower")
    public String editPower(@Valid Power toEdit, BindingResult result) {
        if (result.hasErrors()) {
            return "editPower";
        }
        try {
            service.editPower(toEdit);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("power", "superPower", "Name already exists.");
            result.addError(error);
            return "editPower";
        }
        
        return "redirect:/powers";
    }
}
