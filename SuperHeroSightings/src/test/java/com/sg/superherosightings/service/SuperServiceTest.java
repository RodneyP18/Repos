/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import TempDaoTest.HeroRepInMem;
import TempDaoTest.LocRepInMem;
import TempDaoTest.OrgRepInMem;
import TempDaoTest.PowerRepInMem;
import TempDaoTest.SightRepInMem;
import TempDaoTest.SuperHeroDaoInMem;
import com.sg.superherosightings.dao.SuperHeroDao;
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
    
    HeroRep heroRepTest = new HeroRepInMem();
    PowerRep powerRepTest = new PowerRepInMem();
    OrganizationRep orgRepTest = new OrgRepInMem();
    LocationRep locRepTest = new LocRepInMem();
    SightingRep sightRepTest = new SightRepInMem();
    SuperHeroDao superHeroDaoTest = new SuperHeroDaoInMem();
    
            
            
    public SuperServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        
    }

    @Test
    public void getHeroByIdGoldenPath() {
        Optional<Hero> heroes = heroRepTest.findById(1);
        
        
    }

    @Test
    public void deleteHeroGoldenPath() {
        heroRepTest.deleteById(1);
    }

    @Test
    public void addHeroGoldenPath() {
        Hero newHero = new Hero();
        heroRepTest.save(newHero);
    }

    @Test
    public void editHeroGoldenPath() {
        Optional<Hero> toEdit = heroRepTest.findById(1);
        
        heroRepTest.save(toEdit);
    }

    @Test
    public void getAllHeroesGoldenPath() {
        List<Hero> allHeroes = heroRepTest.findAll();
        
    }

    @Test
    public void getPowerByIdGoldenPath() {
        Optional<Power> powers = powerRepTest.findById(1);
        
        
    }

    @Test
    public void deletePowerGoldenPath() {
        powerRepTest.deleteById(1);
    }

    @Test
    public void addPowerGoldenPath() {
        Power newPower = new Power();
        powerRepTest.save(newPower);
    }

    @Test
    public void getAllPowersGoldenPath() {
        List<Power> allPowers = powerRepTest.findAll();
        
    }

    @Test
    public void editPowerGoldenPath() {
        Optional<Power> toEdit = powerRepTest.findById(1);
        
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
        sightRepTest.deleteById(1);
    }

    @Test
    public void getSightingByIdGoldenPath() {
        Optional<Sighting> sightings = sightRepTest.findById(1);
        
        
    }

    @Test
    public void editSightingGoldenPath() {
        Optional<Sighting> toEdit = sightRepTest.findById(1);
        
        sightRepTest.save(toEdit);
    }

    @Test
    public void addOrgGoldenPath() {
        orgRepTest.save(newOrg);
    }

    @Test
    public void deleteOrgGoldenPath() {
        orgRepTest.deleteById(1);
    }

    @Test
    public void getAllOrganizationsGoldenPath() {
        List<Organization> allOrganizations = orgRepTest.findAll();
        
    }

    @Test
    public void getOrgByIdGoldenPath() {
        Optional<Organization> organizations = orgRepTest.findById(1);
        
        
    }

    @Test
    public void editOrgGoldenPath() {
        Optional<Organization> toEdit = orgRepTest.findById(1);
        
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
        locRepTest.deleteById(1);
    }

    @Test
    public void getLocationByIdGoldenPath() {
        Optional<Location> locations = locRepTest.findById(1);
        
        
    }

    @Test
    public void editLocationGoldenPath() {
        Optional<Location> toEdit = locRepTest.findById(1);
        
        locRepTest.save(toEdit);
    }

    @Test
    public void getMatchingOrgsGoldenPath() {
        List<Organization> matchingOrgs = new ArrayList<>();
        for (String orgId : orgIds) {
            matchingOrgs.add(orgRepTest.getOne(Integer.parseInt(orgId)));
        }
        
    }
    
    public List<Sighting> getRecentSightings() {
        List<Sighting> recentSightings = superHeroDaoTest.getTenRecentSights();
        return recentSightings;
    }

}
