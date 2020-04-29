/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Organization;
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
public class OrgController {

    @Autowired
    SuperService service;

    @GetMapping("/organizations")
    public String displayOrgs(Model model) {
        List<Organization> allOrgs = service.getAllOrganizations();
        List<Hero> allHeroes = service.getAllHeroes();
        model.addAttribute("heroes", allHeroes);
        model.addAttribute("errors", new ArrayList<>());
        model.addAttribute("orgs", allOrgs);
        return "organizations";
    }

    @PostMapping("/addOrg")
    public String addOrg(@Valid Organization newOrg, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Organization> organizations = service.getAllOrganizations();
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("organization", newOrg);
            model.addAttribute("organizations", organizations);

            return "organizations";
        }
        try {
            service.addOrg(newOrg);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("organization", "orgName", "Name already exists.");
            result.addError(error);
            return "organizations";
        }
        
        return "redirect:/organizations";
    }

    @RequestMapping("/deleteOrg/{id}")
    public String deleteOrg(@PathVariable(name = "id") Integer id) {
        service.deleteOrg(id);
        return "redirect:/organizations";
    }

    @RequestMapping("/editOrg/{id}")
    public String editOrg(@PathVariable(name = "id") Integer id, Model model) {
        Organization toEdit = service.getOrgById(id);
        List<Hero> allHeroes = service.getAllHeroes();
        model.addAttribute("members", allHeroes);     
        model.addAttribute("toEdit", toEdit);
        return "editOrg";
    }

    @PostMapping("/editOrg")
    public String editOrg(@Valid Organization toEdit, BindingResult result, HttpServletRequest request, Model model) {
        String[] heroIds = request.getParameterValues("members");
        List<Hero> members = new ArrayList<>();
        if(heroIds != null) {
            for(String heroId : heroIds) {
                members.add(service.getHeroById(Integer.parseInt(heroId)));
            }
        } else {
            FieldError error = new FieldError("toEdit", "members", "Must include one hero");
            result.addError(error);
        }
        
        toEdit.setMembers(members);
        
        if(result.hasErrors()) {
            model.addAttribute("members", service.getAllHeroes());
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("toEdit", toEdit);
            return "editOrg";
        }
        try {
            service.editOrg(toEdit);
        } catch (DuplicateInputException ex) {
            FieldError error = new FieldError("organization", "orgName", "Name already exists.");
            result.addError(error);
            return "editOrg";
        }
        
        
        
        return "redirect:/organizations";
    }
    
    @GetMapping("/orgDetails/{id}")
    public String orgDetails(@PathVariable(name = "id") Integer id, Model model) {
        Organization toDisplay = service.getOrgById(id);
        List<Hero> orgHeroes = toDisplay.getMembers();
        model.addAttribute("members", orgHeroes);
        model.addAttribute("org", toDisplay);
        
        return "orgHeroDetails";
    }
}
