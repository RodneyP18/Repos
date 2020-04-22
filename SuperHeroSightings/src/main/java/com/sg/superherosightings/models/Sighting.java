/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Buddy
 */
@Entity
@Table(name = "sightings")
public class Sighting {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int sightingId;

    @ManyToOne
    @JoinColumn(name = "heroId", nullable = false)
    private Hero superHero;

    @ManyToOne
    @JoinColumn(name = "locationId", nullable = false)
    private Location heroLocation;

    @Column(nullable = false)
    private LocalDate sightingDate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.sightingId;
        hash = 47 * hash + Objects.hashCode(this.superHero);
        hash = 47 * hash + Objects.hashCode(this.heroLocation);
        hash = 47 * hash + Objects.hashCode(this.sightingDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (!Objects.equals(this.superHero, other.superHero)) {
            return false;
        }
        if (!Objects.equals(this.heroLocation, other.heroLocation)) {
            return false;
        }
        if (!Objects.equals(this.sightingDate, other.sightingDate)) {
            return false;
        }
        return true;
    }

    
    /**
     * @return the sightingId
     */
    public int getSightingId() {
        return sightingId;
    }

    /**
     * @param sightingId the sightingId to set
     */
    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    /**
     * @return the superHero
     */
    public Hero getSuperHero() {
        return superHero;
    }

    /**
     * @param superHero the superHero to set
     */
    public void setSuperHero(Hero superHero) {
        this.superHero = superHero;
    }

    /**
     * @return the heroLocation
     */
    public Location getHeroLocation() {
        return heroLocation;
    }

    /**
     * @param heroLocation the heroLocation to set
     */
    public void setHeroLocation(Location heroLocation) {
        this.heroLocation = heroLocation;
    }

    /**
     * @return the sightingDate
     */
    public LocalDate getSightingDate() {
        return sightingDate;
    }

    /**
     * @param sightingDate the sightingDate to set
     */
    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

    
}
