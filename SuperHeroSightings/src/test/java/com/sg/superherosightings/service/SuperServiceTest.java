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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        Hero toGet = allHeroes.get(0);

        assertEquals(2, toGet.getHeroId());
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
        Hero toGet = heroRepTest.findById(3).get();

        assertEquals("Joe", toGet.getName());
        assertEquals("Way Cool", toGet.getDescription());
        assertEquals("Invisibility", toGet.getSuperPower().getSuperPower());
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

        Hero toTest = heroRepTest.findById(1).get();

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
        Power power = powerRepTest.findById(1).get();

        assertEquals("Flying", power.getSuperPower());

    }

    @Test
    public void deletePowerGoldenPath() {
        powerRepTest.deleteById(1);
        List<Power> allPowers = powerRepTest.findAll();

        assertEquals(1, allPowers.size());

        Power toGet = allPowers.get(0);

        assertEquals(2, toGet.getPowerId());

    }

    @Test
    public void addPowerGoldenPath() {
        Power newPower = new Power();
        newPower.setSuperPower("Invisibility");

        powerRepTest.save(newPower);
        Power toGet = powerRepTest.findById(3).get();

        assertEquals("Invisibility", toGet.getSuperPower());
    }

    @Test
    public void getAllPowersGoldenPath() {
        List<Power> allPowers = powerRepTest.findAll();

        Power powerOne = allPowers.get(0);

        assertEquals("Flying", powerOne.getSuperPower());

        Power powerTwo = allPowers.get(1);

        assertEquals("Speed", powerTwo.getSuperPower());
    }

    @Test
    public void editPowerGoldenPath() {
        Power toEdit = powerRepTest.findById(1).get();

        toEdit.setSuperPower("Something");
        powerRepTest.save(toEdit);

        Power toGet = powerRepTest.findById(1).get();

        assertEquals("Something", toGet.getSuperPower());

    }

    @Test
    public void getAllSightingsGoldenPath() {
        List<Sighting> allSightings = sightRepTest.findAll();
        
        assertEquals(11, allSightings.size());

        Sighting firstSight = allSightings.get(0);

        assertEquals(1, firstSight.getSightingId());
        assertEquals("Buddy", firstSight.getSuperHero().getName());
        assertEquals("Minneapolis", firstSight.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 4, 2), firstSight.getSightingDate());

        Sighting lastSight = allSightings.get(10);

        assertEquals(11, lastSight.getSightingId());
        assertEquals("Rodney", lastSight.getSuperHero().getName());
        assertEquals("New York", lastSight.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 4, 22), lastSight.getSightingDate());

    }

    @Test
    public void addSightingGoldenPath() {
        Sighting newSighting = new Sighting();
        Hero testHero = heroRepTest.findById(1).get();
        Location testLoc = locRepTest.findById(1).get();
        
        newSighting.setSuperHero(testHero);
        newSighting.setHeroLocation(testLoc);
        newSighting.setSightingDate(LocalDate.of(2020, 4, 24));
        
        sightRepTest.save(newSighting);
        
        Sighting toGet = sightRepTest.findById(12).get();
        
        assertEquals("Buddy", toGet.getSuperHero().getName());
        assertEquals("Minneapolis", toGet.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 4, 24), toGet.getSightingDate());
        
    }

    @Test
    public void deleteSightingGoldenPath() {
        sightRepTest.deleteById(1);
        List<Sighting> allSightings = sightRepTest.findAll();
        
        assertEquals(10, allSightings.size());
        
    }

    @Test
    public void getSightingByIdGoldenPath() {
        Sighting sighting = sightRepTest.findById(1).get();
        
        assertEquals("Buddy", sighting.getSuperHero().getName());
        assertEquals("Minneapolis", sighting.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 4, 2), sighting.getSightingDate());

    }

    @Test
    public void editSightingGoldenPath() {
        Sighting toEdit = sightRepTest.findById(1).get();
        Hero testHero = new Hero();
        testHero.setName("Bob");
        Location testLoc = new Location();
        testLoc.setLocationName("Florida");

        toEdit.setSuperHero(testHero);
        toEdit.setHeroLocation(testLoc);
        toEdit.setSightingDate(LocalDate.of(2020, 3, 20));
        
        sightRepTest.save(toEdit);
        Sighting toGet = sightRepTest.findById(1).get();
        
        assertEquals("Bob", toGet.getSuperHero().getName());
        assertEquals("Florida", toGet.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 3, 20), toGet.getSightingDate());

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
        List<Organization> allOrgs = orgRepTest.findAll();
        
        assertEquals(1, allOrgs.size());
    }

    @Test
    public void getAllOrganizationsGoldenPath() {
        List<Organization> allOrgs = orgRepTest.findAll();

        assertEquals(2, allOrgs.size());
        
        Organization orgOne = allOrgs.get(0);
        
        assertEquals(1, orgOne.getOrgId());
        assertEquals("SG", orgOne.getOrgName());
        assertEquals("Super", orgOne.getOrgDesc());
        assertEquals("345 Way", orgOne.getAddress());
        assertEquals("sg.com", orgOne.getEmail());
        assertEquals("123-324-3456", orgOne.getPhone());
        
        
        Organization orgTwo = allOrgs.get(1);
        
        assertEquals(2, orgTwo.getOrgId());
        assertEquals("SHS", orgTwo.getOrgName());
        assertEquals("Semi-Super", orgTwo.getOrgDesc());
        assertEquals("456 Drive", orgTwo.getAddress());
        assertEquals("shs.com", orgTwo.getEmail());
        assertEquals("234-345-4567", orgTwo.getPhone());
        
    }

    @Test
    public void getOrgByIdGoldenPath() {
        Organization org = orgRepTest.findById(1).get();
        
        assertEquals(1, org.getOrgId());
        assertEquals("SG", org.getOrgName());
        assertEquals("Super", org.getOrgDesc());
        assertEquals("345 Way", org.getAddress());
        assertEquals("sg.com", org.getEmail());
        assertEquals("123-324-3456", org.getPhone());

    }

    @Test
    public void editOrgGoldenPath() {
        Organization toEdit = orgRepTest.findById(1).get();

        toEdit.setOrgName("TestOrg");
        toEdit.setOrgDesc("Test");
        toEdit.setAddress("9090 Blvd");
        toEdit.setEmail("org.com");
        toEdit.setPhone("999-999-9999");
        
        orgRepTest.save(toEdit);
        Organization toGet = orgRepTest.findById(1).get();
        
        assertEquals("TestOrg", toGet.getOrgName());
        assertEquals("Test", toGet.getOrgDesc());
        assertEquals("9090 Blvd", toGet.getAddress());
        assertEquals("org.com", toGet.getEmail());
        assertEquals("999-999-9999", toGet.getPhone());
    }

    @Test
    public void getAllLocationsGoldenPath() {
        List<Location> allLocations = locRepTest.findAll();
        
        assertEquals(2, allLocations.size());
        
        Location locOne = allLocations.get(0);
        
        assertEquals(1, locOne.getLocationId());
        assertEquals("Minneapolis", locOne.getLocationName());
        assertEquals("Cool", locOne.getLocationDesc());
        assertEquals("123 Way", locOne.getAddress());
        assertEquals(new BigDecimal("90"), locOne.getLatitude());
        assertEquals(new BigDecimal("180"), locOne.getLongitude());
        
        Location locTwo = allLocations.get(1);
        
        assertEquals(2, locTwo.getLocationId());
        assertEquals("New York", locTwo.getLocationName());
        assertEquals("Uncool", locTwo.getLocationDesc());
        assertEquals("234 Drive", locTwo.getAddress());
        assertEquals(new BigDecimal("89"), locTwo.getLatitude());
        assertEquals(new BigDecimal("179"), locTwo.getLongitude());

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

        Location toGet = locRepTest.findById(3).get();

        assertEquals("Florida", toGet.getLocationName());
        assertEquals("Somewhere", toGet.getLocationDesc());
        assertEquals("9876 Blvd", toGet.getAddress());
        assertEquals(new BigDecimal("71"), toGet.getLatitude());
        assertEquals(new BigDecimal("121"), toGet.getLongitude());
    }

    @Test
    public void deleteLocationGoldenPath() {
        locRepTest.deleteById(1);
        List<Location> allLocations = locRepTest.findAll();
        
        assertEquals(1, allLocations.size());
    }

    @Test
    public void getLocationByIdGoldenPath() {
        Location loc = locRepTest.findById(1).get();
        
        assertEquals("Minneapolis", loc.getLocationName());
        assertEquals("Cool", loc.getLocationDesc());
        assertEquals("123 Way", loc.getAddress());
        assertEquals(new BigDecimal("90"), loc.getLatitude());
        assertEquals(new BigDecimal("180"), loc.getLongitude());
        
    }

    @Test
    public void editLocationGoldenPath() {
        Location toEdit = locRepTest.findById(1).get();
        
        toEdit.setLocationName("Florida");
        toEdit.setLocationDesc("Bad");
        toEdit.setAddress("84 Never");
        toEdit.setLatitude(new BigDecimal("50"));
        toEdit.setLongitude(new BigDecimal("100"));

        locRepTest.save(toEdit);
        Location toGet = locRepTest.findById(1).get();
        
        assertEquals("Florida", toGet.getLocationName());
        assertEquals("Bad", toGet.getLocationDesc());
        assertEquals("84 Never", toGet.getAddress());
        assertEquals(new BigDecimal("50"), toGet.getLatitude());
        assertEquals(new BigDecimal("100"), toGet.getLongitude());
    }

    @Test
    public void getMatchingOrgsGoldenPath() {
//        List<Organization> matchingOrgs = new ArrayList<>();
//        for (String orgId : orgIds) {
//            matchingOrgs.add(orgRepTest.getOne(Integer.parseInt(orgId)));
//        }

    }

    public void getRecentSightings() {
        List<Sighting> recentSightings = superHeroDaoTest.getTenRecentSights();

    }

}
