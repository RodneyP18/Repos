/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Buddy
 */
@Entity
@Table (name = "heroes")
public class Hero {
    
    public Hero(){
        superPower = new Power();
        orgs = new ArrayList<>();
    }

    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int heroId;
    
    @Column(nullable = false)
    @NotBlank(message = "Name must not be empty.")
    private String name;
    
    @Column(nullable = false)
    @NotBlank(message = "Description must not be empty.")
    private String description;
    
    @ManyToOne
    @JoinColumn( name = "powerId", nullable = false)
    @NotNull(message = "Description must not be empty.")
    private Power superPower;
    
    @ManyToMany(mappedBy = "members")
    private List<Organization> orgs;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.heroId;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.superPower);
        hash = 67 * hash + Objects.hashCode(this.orgs);
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
        final Hero other = (Hero) obj;
        if (this.heroId != other.heroId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.superPower, other.superPower)) {
            return false;
        }
        if (!Objects.equals(this.orgs, other.orgs)) {
            return false;
        }
        return true;
    }

    /**
     * @return the heroId
     */
    public int getHeroId() {
        return heroId;
    }

    /**
     * @param heroId the heroId to set
     */
    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the superPower
     */
    public Power getSuperPower() {
        return superPower;
    }

    /**
     * @param superPower the superPower to set
     */
    public void setSuperPower(Power superPower) {
        this.superPower = superPower;
    }

    /**
     * @return the orgs
     */
    public List<Organization> getOrgs() {
        return orgs;
    }

    /**
     * @param orgs the orgs to set
     */
    public void setOrgs(List<Organization> orgs) {
        this.orgs = orgs;
    }

}