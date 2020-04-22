/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SuperHeroDaoTemp;
import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Organization;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.models.Sighting;
import com.sg.superherosightings.repository.HeroRep;
import com.sg.superherosightings.repository.LocationRep;
import com.sg.superherosightings.repository.OrganizationRep;
import com.sg.superherosightings.repository.PowerRep;
import com.sg.superherosightings.repository.SightingRep;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Buddy
 */
@Service
public class SuperService {

    @Autowired
    HeroRep heroRepo;

    @Autowired
    PowerRep powerRepo;

    @Autowired
    LocationRep locationRepo;

    @Autowired
    OrganizationRep orgRepo;

    @Autowired
    SightingRep sightingRepo;
    
    @Autowired
    SuperHeroDaoTemp superTemp;

    public Hero getHeroById(Integer id) {
        Optional<Hero> heroes = heroRepo.findById(id);
        Hero toReturn = null;
        toReturn = heroes.get();
        return toReturn;
    }

    public void deleteHero(Integer id) {
        heroRepo.deleteById(id);
    }

    public void addHero(Hero newHero) {
        heroRepo.save(newHero);
    }
    
    public void editHero(Hero toEdit) {
        heroRepo.save(toEdit);
    }

    public List<Hero> getAllHeroes() {
        List<Hero> allHeroes = heroRepo.findAll();
        return allHeroes;
    }

    public Power getPowerById(Integer id) {
        Optional<Power> powers = powerRepo.findById(id);
        Power toReturn = null;
        toReturn = powers.get();
        return toReturn;
    }

    public void deletePower(Integer id) {
        powerRepo.deleteById(id);
    }

    public void addPower(Power newPower) {
        powerRepo.save(newPower);
    }

    public List<Power> getAllPowers() {
        List<Power> allPowers = powerRepo.findAll();
        return allPowers;
    }

    public void editPower(Power toEdit) {
        powerRepo.save(toEdit);
    }

    public List<Sighting> getAllSightings() {
        List<Sighting> allSightings = sightingRepo.findAll();
        return allSightings;
    }

    public void addSighting(Sighting newSighting) {
        sightingRepo.save(newSighting);
    }

    public void deleteSighting(Integer id) {
        sightingRepo.deleteById(id);
    }

    public Sighting getSightingById(Integer id) {
        Optional<Sighting> sightings = sightingRepo.findById(id);
        Sighting toReturn = null;
        toReturn = sightings.get();
        return toReturn;
    }

    public void editSighting(Sighting toEdit) {
        sightingRepo.save(toEdit);
    }

    

    public void addOrg(Organization newOrg) {
        orgRepo.save(newOrg);
    }

    public void deleteOrg(Integer id) {
        orgRepo.deleteById(id);
    }

    public List<Organization> getAllOrganizations() {
        List<Organization> allOrganizations = orgRepo.findAll();
        return allOrganizations;
    }

    public Organization getOrgById(Integer id) {
        Optional<Organization> organizations = orgRepo.findById(id);
        Organization toReturn = null;
        toReturn = organizations.get();
        return toReturn;
    }

    public void editOrg(Organization toEdit) {
        orgRepo.save(toEdit);
    }

    public List<Location> getAllLocations() {
        List<Location> allLocations = locationRepo.findAll();
        return allLocations;
    }

    public void addLocation(Location newLocation) {
        locationRepo.save(newLocation);
    }

    public void deleteLocation(Integer id) {
        locationRepo.deleteById(id);
    }

    public Location getLocationById(Integer id) {
        Optional<Location> locations = locationRepo.findById(id);
        Location toReturn = null;
        toReturn = locations.get();
        return toReturn;
    }

    public void editLocation(Location toEdit) {
        locationRepo.save(toEdit);
    }

    public List<Organization> getMatchingOrgs(String[] orgIds) {
        List<Organization> matchingOrgs = new ArrayList<>();
        for(String orgId : orgIds){
            matchingOrgs.add(orgRepo.getOne(Integer.parseInt(orgId)));
        }
        return matchingOrgs;
    }

    public List<Sighting> getRecentSightings() {
        List<Sighting> recentSightings = superTemp.getTenRecentSights();
        return recentSightings;
    }
    
    
}
