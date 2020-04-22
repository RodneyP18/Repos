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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Buddy
 */
public class SuperServiceTest {
    
    HeroRep heroRepTest;
    PowerRep powerRepTest;
    OrganizationRep orgRepTest;
    LocationRep locRepTest;
    SightingRep sightRepTest;
    SuperHeroDaoTemp superTempTest;
            
            
    public SuperServiceTest() {
    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getHeroByIdGoldenPath() {
        Optional<Hero> heroes = heroRepTest.findById(id);
        Hero toReturn = null;
        toReturn = heroes.get();
        
    }

    @Test
    public void deleteHeroGoldenPath() {
        heroRepTest.deleteById(id);
    }

    @Test
    public void addHeroGoldenPath() {
        heroRepTest.save(newHero);
    }

    @Test
    public void editHeroGoldenPath() {
        heroRepTest.save(toEdit);
    }

    @Test
    public void getAllHeroesGoldenPath() {
        List<Hero> allHeroes = heroRepTest.findAll();
        
    }

    @Test
    public void getPowerByIdGoldenPath() {
        Optional<Power> powers = powerRepTest.findById(id);
        Power toReturn = null;
        toReturn = powers.get();
        
    }

    @Test
    public void deletePowerGoldenPath() {
        powerRepTest.deleteById(id);
    }

    @Test
    public void addPowerGoldenPath() {
        powerRepTest.save(newPower);
    }

    @Test
    public void getAllPowersGoldenPath() {
        List<Power> allPowers = powerRepTest.findAll();
        return allPowers;
    }

    @Test
    public void editPowerGoldenPath() {
        powerRepTest.save(toEdit);
    }

    @Test
    public void getAllSightingsGoldenPath() {
        List<Sighting> allSightings = sightRepTest.findAll();
        
    }

    @Test
    public void addSightingGoldenPath() {
        sightRepTest.save(newSighting);
    }

    @Test
    public void deleteSightingGoldenPath() {
        sightRepTest.deleteById(id);
    }

    @Test
    public void getSightingByIdGoldenPath() {
        Optional<Sighting> sightings = sightRepTest.findById(id);
        Sighting toReturn = null;
        toReturn = sightings.get();
        
    }

    @Test
    public void editSightingGoldenPath() {
        sightRepTest.save(toEdit);
    }

    @Test
    public void addOrgGoldenPath() {
        orgRepTest.save(newOrg);
    }

    @Test
    public void deleteOrgGoldenPath() {
        orgRepTest.deleteById(id);
    }

    @Test
    public void getAllOrganizationsGoldenPath() {
        List<Organization> allOrganizations = orgRepTest.findAll();
        
    }

    @Test
    public void getOrgByIdGoldenPath() {
        Optional<Organization> organizations = orgRepTest.findById(id);
        Organization toReturn = null;
        toReturn = organizations.get();
        
    }

    @Test
    public void editOrgGoldenPath() {
        orgRepTest.save(toEdit);
    }

    @Test
    public void getAllLocationsGoldenPath() {
        List<Location> allLocations = locRepTest.findAll();
        
    }

    @Test
    public void addLocationGoldenPath() {
        locRepTest.save(newLocation);
    }

    @Test
    public void deleteLocationGoldenPath() {
        locRepTest.deleteById(id);
    }

    @Test
    public void getLocationByIdGoldenPath() {
        Optional<Location> locations = locRepTest.findById(id);
        
        
    }

    @Test
    public void editLocationGoldenPath() {
        locRepTest.save(toEdit);
    }

    @Test
    public void getMatchingOrgsGoldenPath() {
        List<Organization> matchingOrgs = new ArrayList<>();
        for (String orgId : orgIds) {
            matchingOrgs.add(orgRepTest.getOne(Integer.parseInt(orgId)));
        }
        
    }

    @Test
    public void getRecentSightingsGoldenPath() {
        List<Sighting> recentSightings = superTempTest.getTenRecentSights();
        
    }

}
