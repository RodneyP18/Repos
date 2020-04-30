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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Hero hero = heroRepTest.findById(1).get();
        
        assertEquals("Buddy", hero.getName());
        assertEquals("Cool", hero.getDescription());
        assertEquals("Flying", hero.getSuperPower().getSuperPower());
        
    }

    @Test
    public void deleteHeroGoldenPath() {
        heroRepTest.deleteById(1);
        List<Hero> allHeroes = heroRepTest.findAll();
        
        assertEquals(1, allHeroes.size());
    }

    @Test
    public void addHeroGoldenPath() {
        Power newPower = new Power();
        newPower.setPowerId(3);
        newPower.setSuperPower("Invisibility");
        
        Hero newHero = new Hero();
        newHero.setName("Joe");
        newHero.setDescription("Way Cool");
        newHero.setSuperPower(newPower);
        
        heroRepTest.save(newHero);
    }

    @Test
    public void editHeroGoldenPath() {
        
        Power newPower = new Power();
        newPower.setPowerId(3);
        newPower.setSuperPower("Regeneration");
        
        Hero toEdit = heroRepTest.findById(1).get();
        
        toEdit.setHeroId(1);
        toEdit.setName("Billy");
        toEdit.setSuperPower(newPower);
        toEdit.setDescription("Semi-Cool");
        
        heroRepTest.save(toEdit);
        
        Hero toTest = heroRepTest.findById(3).get();
        
        assertEquals("Billy", toTest.getName());
        assertEquals("Semi-Cool", toTest.getDescription());
        assertEquals("Regeneration", toTest.getSuperPower().getSuperPower());
        
    }

    @Test
    public void getAllHeroesGoldenPath() {
        List<Hero> allHeroes = heroRepTest.findAll();
        
        assertEquals(2, allHeroes.size());
        
        Hero heroOne = allHeroes.get(0);
        
        assertEquals(1, heroOne.getHeroId());
        assertEquals("Buddy", heroOne.getName());
        assertEquals("Cool", heroOne.getDescription());
        assertEquals("Flying", heroOne.getSuperPower().getSuperPower());
        
        Hero heroTwo = allHeroes.get(1);
        
        assertEquals(2, heroTwo.getHeroId());
        assertEquals("Rodney", heroTwo.getName());
        assertEquals("Uncool", heroTwo.getDescription());
        assertEquals("Speed", heroTwo.getSuperPower().getSuperPower());
        
        
        
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
        newPower.setSuperPower("Invisibility");
        powerRepTest.save(newPower);
    }

    @Test
    public void getAllPowersGoldenPath() {
        List<Power> allPowers = powerRepTest.findAll();
        
    }

    @Test
    public void editPowerGoldenPath() {
        Optional<Power> toEdit = powerRepTest.findById(1);
        
//        powerRepTest.save(toEdit);
    }

    @Test
    public void getAllSightingsGoldenPath() {
        List<Sighting> allSightings = sightRepTest.findAll();
        
    }

    @Test
    public void addSightingGoldenPath() {
//        sightRepTest.save(newSighting);
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
        
//        sightRepTest.save(toEdit);
    }

    @Test
    public void addOrgGoldenPath() {
        List<Hero> heroList = new ArrayList<>();
        
        Power newPower = new Power();
        newPower.setPowerId(3);
        newPower.setSuperPower("Invisibility");
        
        Hero hero = new Hero();
        hero.setHeroId(3);
        hero.setName("Jamie");
        hero.setDescription("Super");
        hero.setSuperPower(newPower);
        
        heroList.add(hero);
        
        Organization newOrg = new Organization();
        newOrg.setOrgName("SuperHeroOrg");
        newOrg.setOrgDesc("Super Heroes");
        newOrg.setAddress("5678 CT");
        newOrg.setEmail("sho.com");
        newOrg.setPhone("567-678-7890");
        newOrg.setMembers(heroList);
        
        orgRepTest.save(newOrg);
        Organization toTest = orgRepTest.findById(3).get();
        
        assertEquals("SuperHeroOrg", toTest.getOrgName());
        assertEquals("Super Heroes", toTest.getOrgDesc());
        assertEquals("5678 CT", toTest.getAddress());
        assertEquals("sho.com", toTest.getEmail());
        assertEquals("567-678-7890", toTest.getPhone());
        
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
        
//        orgRepTest.save(toEdit);
    }

    @Test
    public void getAllLocationsGoldenPath() {
        List<Location> allLocations = locRepTest.findAll();
        
    }

    @Test
    public void addLocationGoldenPath() {
        Location newLoc = new Location();
        
        newLoc.setLocationName("Florida");
        newLoc.setLocationDesc("Somewhere");
        newLoc.setAddress("9876 Blvd");
        newLoc.setLatitude(BigDecimal.valueOf(71));
        newLoc.setLongitude(BigDecimal.valueOf(121));
        
        locRepTest.save(newLoc);
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
        
//        locRepTest.save(toEdit);
    }

    @Test
    public void getMatchingOrgsGoldenPath() {
//        List<Organization> matchingOrgs = new ArrayList<>();
//        for (String orgId : orgIds) {
//            matchingOrgs.add(orgRepTest.getOne(Integer.parseInt(orgId)));
//        }
        
    }
    
    public List<Sighting> getRecentSightings() {
        List<Sighting> recentSightings = superHeroDaoTest.getTenRecentSights();
        return recentSightings;
    }

}
