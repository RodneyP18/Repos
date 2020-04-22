/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Buddy
 */
@Repository
public class SuperHeroDaoTemp implements SuperHeroDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Sighting> getTenRecentSights() {
        
        List<Sighting> recentSightings = template.query("SELECt * FROM Sightings s INNER JOIN Heroes h ON h.heroId = s.heroId\n" +
        "INNER JOIN Locations l ON l.locationId = s.locationId ORDER BY SightingDate DESC LIMIT 0, 10", new SightingMapper());
        return recentSightings;
    }
    
    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet row, int i) throws SQLException {
            Sighting sighting = new Sighting();
            Hero hero = new Hero();
            Location location = new Location();
            sighting.setSightingId(row.getInt("SightingId"));
            hero.setName(row.getString("name"));
            location.setLocationName(row.getString("LocationName"));
            sighting.setSightingDate(LocalDate.parse(row.getDate("sightingDate").toString()));
            sighting.setSuperHero(hero);
            sighting.setHeroLocation(location);
            return sighting;
        }
    }
    
}
