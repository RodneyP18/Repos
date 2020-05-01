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
import com.sg.superherosightings.repository.HeroRep;
import com.sg.superherosightings.repository.LocationRep;
import com.sg.superherosightings.repository.PowerRep;
import com.sg.superherosightings.repository.SightingRep;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Buddy
 */
@SpringBootTest
public class SuperHeroDaoTempTest {
    
    @Autowired
    JdbcTemplate template;

    @Autowired
    SuperHeroDao superTempTest = new SuperHeroDaoTemp();

    @Autowired
    HeroRep heroRepTest;

    @Autowired
    LocationRep locRepTest;

    @Autowired
    PowerRep powerRepTest;

    @Autowired
    SightingRep sightRepTest;

    public SuperHeroDaoTempTest() {
        
    }

    @BeforeEach
    public void setUp() {
        
        String DELETE_SIGHTING = "DELETE FROM Sightings";
        template.update(DELETE_SIGHTING);
        
        String DELETE_LOCATION = "DELETE FROM Locations";
        template.update(DELETE_LOCATION);
        
        String DELETE_HERO = "DELETE FROM Heroes";
        template.update(DELETE_HERO);
        
        String DELETE_POWER = "DELETE FROM Powers";
        template.update(DELETE_POWER);
        
        template.update("Insert into Powers Values ('1', 'Flying'), ('2', 'Speed'), ('3', 'Something');");
        
        template.update("Insert into Heroes Values ('1', 'Buddy', 'Cool', '1'), ('2', 'Rodney', 'Uncool', '2'),('3', 'David', 'Coder', '3');");
        
        template.update("Insert into Locations Values ('1', 'MN', 'Winter', '123 Way', '90', '180'),('2', 'NY', 'Summer', '234 Drive', '89', '179');");
        
        template.update("Insert into Sightings Values ('1', '1', '1', '2020-04-02'),('2', '2', '2', '2020-04-04'),"
                + "('3', '3', '1', '2020-04-06'),('4', '1', '2', '2020-04-08'),('5', '2', '1', '2020-04-10'),('6', '3', '2', '2020-04-12'),"
                + "('7', '1', '1', '2020-04-14'),('8', '2', '2', '2020-04-16'),('9', '3', '1', '2020-04-18'),('10', '1', '2', '2020-04-20'),"
                + "('11', '2', '1', '2020-04-22');");

    }

    @Test
    public void getRecentSightingsGoldenPath() {
        List<Sighting> recentSightings = superTempTest.getTenRecentSights();

        assertEquals(10, recentSightings.size());

        Sighting mostRecentDate = recentSightings.get(0);
        
        assertEquals(11, mostRecentDate.getSightingId());
        assertEquals("Rodney", mostRecentDate.getSuperHero().getName());
        assertEquals("MN", mostRecentDate.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 04, 22), mostRecentDate.getSightingDate());
        
        Sighting secondRecentDate = recentSightings.get(1);
        
        assertEquals(10, secondRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 20), secondRecentDate.getSightingDate());
        
        Sighting thirdRecentDate = recentSightings.get(2);
        
        assertEquals(9, thirdRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 18), thirdRecentDate.getSightingDate());
        
        Sighting fourthRecentDate = recentSightings.get(3);
        
        assertEquals(8, fourthRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 16), fourthRecentDate.getSightingDate());
        
        Sighting fifthRecentDate = recentSightings.get(4);
        
        assertEquals(7, fifthRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 14), fifthRecentDate.getSightingDate());
        
        Sighting sixthRecentDate = recentSightings.get(5);
        
        assertEquals(6, sixthRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 12), sixthRecentDate.getSightingDate());
        
        Sighting seventhRecentDate = recentSightings.get(6);
        
        assertEquals(5, seventhRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 10), seventhRecentDate.getSightingDate());
        
        Sighting eighthRecentDate = recentSightings.get(7);
        
        assertEquals(4, eighthRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 8), eighthRecentDate.getSightingDate());
        
        Sighting ninthRecentDate = recentSightings.get(8);
        
        assertEquals(3, ninthRecentDate.getSightingId());
        assertEquals(LocalDate.of(2020, 04, 06), ninthRecentDate.getSightingDate());
        
        Sighting tenthRecentDate = recentSightings.get(9);
        
        assertEquals(2, tenthRecentDate.getSightingId());
        assertEquals("Rodney", tenthRecentDate.getSuperHero().getName());
        assertEquals("NY", tenthRecentDate.getHeroLocation().getLocationName());
        assertEquals(LocalDate.of(2020, 04, 04), tenthRecentDate.getSightingDate());

        

    }

    @Test
    public void deleteHeroGoldenPath() {
        superTempTest.deleteHero(1);
        List<Hero> allHeroes = heroRepTest.findAll();

        assertEquals(2, allHeroes.size());

    }

    @Test
    public void deletePowerGoldenPath() {
        superTempTest.deletePower(1);
        List<Power> allPowers = powerRepTest.findAll();

        assertEquals(2, allPowers.size());
    }

    @Test
    public void deleteLocationGoldenPath() {
        superTempTest.deleteLocation(1);
        List<Location> allLocations = locRepTest.findAll();

        assertEquals(1, allLocations.size());
    }

}
