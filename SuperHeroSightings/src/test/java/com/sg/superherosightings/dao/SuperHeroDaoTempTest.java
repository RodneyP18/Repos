/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.models.Sighting;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Buddy
 */
public class SuperHeroDaoTempTest {
    
    SuperHeroDaoTemp superTempTest;
    
    List<Sighting> allSightings = new ArrayList<>();
    
    public SuperHeroDaoTempTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        
        Power powerOne = new Power();
        powerOne.setPowerId(1);
        powerOne.setSuperPower("Flying");
        
        Power powerTwo = new Power();
        powerTwo.setPowerId(2);
        powerTwo.setSuperPower("Speed");
        
        Hero heroOne = new Hero();
        heroOne.setHeroId(1);
        heroOne.setName("Buddy");
        heroOne.setSuperPower(powerOne);
        heroOne.setDescription("Cool");
        
        Hero heroTwo = new Hero();
        heroTwo.setHeroId(2);
        heroTwo.setName("Rodney");
        heroTwo.setSuperPower(powerTwo);
        heroTwo.setDescription("Uncool");
        
        Location locationOne = new Location();
        locationOne.setLocationId(1);
        locationOne.setLocationName("Minneapolis");
        
        Location locationTwo = new Location();
        locationTwo.setLocationId(2);
        locationOne.setLocationName("New York");
        
        Sighting sightOne = new Sighting();
        sightOne.setSightingId(1);
        sightOne.setSuperHero(heroOne);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 2));

        Sighting sightTwo = new Sighting();
        sightTwo.setSightingId(2);
        sightTwo.setSuperHero(heroTwo);
        sightTwo.setHeroLocation(locationTwo);
        sightTwo.setSightingDate(LocalDate.of(2020, 4, 4));
        
        Sighting sightThree = new Sighting();
        sightOne.setSightingId(3);
        sightOne.setSuperHero(heroOne);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 6));
        
        Sighting sightFour = new Sighting();
        sightOne.setSightingId(4);
        sightOne.setSuperHero(heroTwo);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 8));
        
        Sighting sightFive = new Sighting();
        sightOne.setSightingId(5);
        sightOne.setSuperHero(heroOne);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 10));
        
        Sighting sightSix = new Sighting();
        sightOne.setSightingId(6);
        sightOne.setSuperHero(heroTwo);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 12));
        
        Sighting sightSeven = new Sighting();
        sightOne.setSightingId(7);
        sightOne.setSuperHero(heroOne);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 14));
        
        Sighting sightEight = new Sighting();
        sightOne.setSightingId(8);
        sightOne.setSuperHero(heroTwo);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 16));
        
        Sighting sightNine = new Sighting();
        sightOne.setSightingId(9);
        sightOne.setSuperHero(heroOne);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 18));
        
        Sighting sightTen = new Sighting();
        sightOne.setSightingId(10);
        sightOne.setSuperHero(heroTwo);
        sightOne.setHeroLocation(locationOne);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 20));
        
        Sighting sightEleven = new Sighting();
        sightOne.setSightingId(11);
        sightOne.setSuperHero(heroTwo);
        sightOne.setHeroLocation(locationTwo);
        sightOne.setSightingDate(LocalDate.of(2020, 4, 22));
        
        allSightings.add(sightOne);
        allSightings.add(sightTwo);
        allSightings.add(sightThree);
        allSightings.add(sightFour);
        allSightings.add(sightFive);
        allSightings.add(sightSix);
        allSightings.add(sightSeven);
        allSightings.add(sightEight);
        allSightings.add(sightNine);
        allSightings.add(sightTen);
        allSightings.add(sightEleven);
        
    }
    
//    @Test
//    public void getRecentSightingsGoldenPath() {
//        List<Sighting> recentSightings = superTempTest.getTenRecentSights();
//        
//    }
//    
//    @Test
//    public void deleteHeroGoldenPath() {
//        superTempTest.deleteHero(1);
//        
//    }
//    
//    @Test
//    public void deletePowerGoldenPath(){
//        superTempTest.deletePower(1);
//        
//    }
//    
//    @Test
//    public void deleteLocationGoldenPath(){
//        superTempTest.deleteLocation(1);
//        
//    }

    
    

}
