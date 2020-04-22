/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.repository;

import com.sg.superherosightings.models.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Buddy
 */
@Repository
public interface PowerRep extends JpaRepository<Power, Integer>{
    
}
