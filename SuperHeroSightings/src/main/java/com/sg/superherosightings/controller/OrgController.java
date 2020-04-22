/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.models.Organization;
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
public class OrgController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("/organizations")
    public String displayOrgs(Model model) {
        List<Organization> allOrgs = service.getAllOrganizations();
        model.addAttribute("orgs", allOrgs);
        return "organizations";
    }
    
    @PostMapping("/addOrg")
    public String addOrg (Organization newOrg){
        service.addOrg(newOrg);
        return "redirect:/organizations";
    }
    
    @RequestMapping("/deleteOrg/{id}")
    public String deleteOrg(@PathVariable(name = "id") Integer id) {
        service.deleteOrg(id);
        return "redirect:/organizations";
    }
    
    @RequestMapping("/editOrg/{id}")
    public String editOrg(@PathVariable(name = "id") Integer id, Model model){
        Organization toEdit = service.getOrgById(id);
        model.addAttribute("toEdit", toEdit);
        return "editOrg";
    }
    @PostMapping("/editOrg")
    public String editOrg(Organization toEdit){
        service.editOrg(toEdit);
        return "redirect:/organizations";
    }
}
