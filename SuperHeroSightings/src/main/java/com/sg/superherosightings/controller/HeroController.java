/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Organization;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.service.DuplicateInputException;
import com.sg.superherosightings.service.SuperService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class HeroController {

    @Autowired
    SuperService service;

    @GetMapping("/heroes")
    public String displayHeroes(Model model) {
        List<Hero> allHeroes = service.getAllHeroes();
        List<Power> allPowers = service.getAllPowers();
        List<Organization> allOrgs = service.getAllOrganizations();
        model.addAttribute("errors", new ArrayList<>());
        model.addAttribute("hero", new Hero());
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("powers", allPowers);
        model.addAttribute("orgs", allOrgs);
        return "heroes";
    }

    @PostMapping("/addHero")
    public String addHero(@Valid Hero newHero, BindingResult result, Model model, HttpServletRequest request){
        if (result.hasErrors()) {
            List<Hero> heroes = service.getAllHeroes();
            List<Power> allPowers = service.getAllPowers();
            List<Organization> allOrgs = service.getAllOrganizations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("hero", newHero);
            model.addAttribute("heroes", heroes);
            model.addAttribute("powers", allPowers);
            model.addAttribute("orgs", allOrgs);
            String[] orgIds = request.getParameterValues("selectedOrgIds");
            List<Organization> matchingOrgs = service.getMatchingOrgs(orgIds);
            newHero.setOrgs(matchingOrgs);

            return "heroes";
        }
        try {
            service.addHero(newHero);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("hero", "name", "Hero Name already selected.");
            result.addError(error);
            List<Power> allPowers = service.getAllPowers();
            List<Organization> allOrgs = service.getAllOrganizations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("orgs", allOrgs);
            model.addAttribute("heroes", service.getAllHeroes());
            model.addAttribute("hero", newHero);
            model.addAttribute("powers", allPowers);
            return "heroes";
        }

        
        return "redirect:/heroes";
    }

    @RequestMapping("/deleteHero/{id}")
    public String deleteHero(@PathVariable(name = "id") Integer id) {
        service.deleteHero(id);
        return "redirect:/heroes";
    }

    @RequestMapping("/editHero/{id}")
    public String editHero(@PathVariable(name = "id") Integer id, Model model) {
        List<Power> allPowers = service.getAllPowers();
        List<Organization> allOrgs = service.getAllOrganizations();
        Hero toEdit = service.getHeroById(id);
        model.addAttribute("orgs", allOrgs);
        model.addAttribute("toEdit", toEdit);
        model.addAttribute("powers", allPowers);

        return "editHero";
    }

    @PostMapping("/editHero")
    public String editHero(@Valid Hero toEdit, BindingResult result, Model model){
        if (result.hasErrors()) {
            List<Power> allPowers = service.getAllPowers();
            List<Organization> allOrgs = service.getAllOrganizations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("orgs", allOrgs);
            model.addAttribute("toEdit", toEdit);
            model.addAttribute("powers", allPowers);
            return "editHero";
        }
        try {
            service.editHero(toEdit);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("hero", "name", "Hero Name already selected.");
            result.addError(error);
            List<Power> allPowers = service.getAllPowers();
            List<Organization> allOrgs = service.getAllOrganizations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("heroes", service.getAllHeroes());
            model.addAttribute("orgs", allOrgs);
            model.addAttribute("toEdit", toEdit);
            model.addAttribute("powers", allPowers);
            return "editHero";
        }
        
        return "redirect:/heroes";
    }

    @GetMapping("/heroDetails/{id}")
    public String heroDetails(@PathVariable(name = "id") Integer id, Model model) {
        Hero toDisplay = service.getHeroById(id);
        List<Organization> heroOrgs = toDisplay.getOrgs();
        model.addAttribute("orgs", heroOrgs);
        model.addAttribute("hero", toDisplay);

        return "heroOrgDetails";
    }
}
