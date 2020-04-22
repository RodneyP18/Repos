/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.models.Sighting;
import java.util.List;

/**
 *
 * @author Buddy
 */
public interface SuperHeroDao {
    public List<Sighting> getTenRecentSights();
}
