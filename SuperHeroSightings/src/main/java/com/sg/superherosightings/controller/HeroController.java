/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Organization;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.service.SuperService;
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
public class HeroController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("/heroes")
    public String displayHeroes(Model model){
        List<Hero> allHeroes = service.getAllHeroes();
        List<Power> allPowers = service.getAllPowers();
        List<Organization> allOrgs = service.getAllOrganizations();
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("powers", allPowers);
        model.addAttribute("orgs", allOrgs);
        return "heroes";
    }

    @PostMapping("/addHero")
    public String addHero (Hero newHero, HttpServletRequest request){
        String[] orgIds = request.getParameterValues("selectedOrgIds");
        List<Organization> matchingOrgs = service.getMatchingOrgs(orgIds);
        newHero.setOrgs(matchingOrgs);
        service.addHero(newHero);
        return "redirect:/heroes";
    }
    
    @RequestMapping("/deleteHero/{id}")
    public String deleteHero(@PathVariable(name = "id") Integer id) {
        service.deleteHero(id);
        return "redirect:/heroes";
    }
    
    @RequestMapping("/editHero/{id}")
    public String editHero(@PathVariable(name = "id") Integer id, Model model){
        List<Power> allPowers = service.getAllPowers();
        Hero toEdit = service.getHeroById(id);
        model.addAttribute("toEdit", toEdit);
        model.addAttribute("powers", allPowers);
        return "editHero";
    }
    
    
    @PostMapping("/editHero")
    public String editHero(Hero toEdit){
        service.editHero(toEdit);
        return "redirect:/heroes";
    }
}
