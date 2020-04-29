/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.models.Sighting;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Buddy
 */
public class SuperHeroDaoTempTest {
    
    SuperHeroDaoTemp superTempTest;
    
    public SuperHeroDaoTempTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        
        
    }
    
    @Test
    public void getRecentSightingsGoldenPath() {
        List<Sighting> recentSightings = superTempTest.getTenRecentSights();
        
       
        
        
    }
    
    

}
