/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.service;

import com.sg.superherosightings.dao.SuperHeroDaoTemp;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Buddy
 */
@Service
public class SuperService {

    @Autowired
    HeroRep heroRepo;

    @Autowired
    PowerRep powerRepo;

    @Autowired
    LocationRep locationRepo;

    @Autowired
    OrganizationRep orgRepo;

    @Autowired
    SightingRep sightingRepo;

    @Autowired
    SuperHeroDaoTemp superTemp;

    public Hero getHeroById(Integer id) {
        Optional<Hero> heroes = heroRepo.findById(id);
        Hero toReturn = null;
        toReturn = heroes.get();
        return toReturn;
    }

    public void deleteHero(Integer id) {
        superTemp.deleteHero(id);
    }

    public void addHero(Hero newHero) throws DuplicateInputException {
        List<Hero> allHeroes = heroRepo.findAll();
        for (Hero hero : allHeroes) {
            if (newHero.getName().equals(hero.getName())) {
                throw new DuplicateInputException("Name already exists");
            }

        }
        heroRepo.save(newHero);
    }

    public void editHero(Hero toEdit) throws DuplicateInputException {
        List<Hero> allHeroes = heroRepo.findAll();
        for (Hero hero : allHeroes) {
            if (toEdit.getHeroId() != hero.getHeroId()) {
                if (toEdit.getName().equals(hero.getName())) {
                    throw new DuplicateInputException("Name already exists");
                }
            }
        }
        heroRepo.save(toEdit);
    }

    public List<Hero> getAllHeroes() {
        List<Hero> allHeroes = heroRepo.findAll();
        return allHeroes;
    }

    public Power getPowerById(Integer id) {
        Optional<Power> powers = powerRepo.findById(id);
        Power toReturn = null;
        toReturn = powers.get();
        return toReturn;
    }

    public void deletePower(Integer id) {
        superTemp.deletePower(id);
    }

    public void addPower(Power newPower) throws DuplicateInputException {
        List<Power> allPowers = powerRepo.findAll();
        for (Power power : allPowers) {
            if (newPower.getSuperPower().equals(power.getSuperPower())) {
                throw new DuplicateInputException("Super power already exists");
            }
        }
        powerRepo.save(newPower);
    }

    public List<Power> getAllPowers() {
        List<Power> allPowers = powerRepo.findAll();
        return allPowers;
    }

    public void editPower(Power toEdit) throws DuplicateInputException {
        List<Power> allPowers = powerRepo.findAll();
        for (Power power : allPowers) {
            if (toEdit.getPowerId() != power.getPowerId()) {
                if (toEdit.getSuperPower().equals(power.getSuperPower())) {
                    throw new DuplicateInputException("Name already exists");
                }
            }
        }
        powerRepo.save(toEdit);
    }

    public List<Sighting> getAllSightings() {
        List<Sighting> allSightings = sightingRepo.findAll();
        return allSightings;
    }

    public void addSighting(Sighting newSighting) throws InvalidInputException {
        if (newSighting.getSightingDate().isAfter(LocalDate.now())) {
            throw new InvalidInputException("Please enter a valid date. Date selected is in the future.");
        }
        sightingRepo.save(newSighting);
    }

    public void deleteSighting(Integer id) {
        sightingRepo.deleteById(id);
    }

    public Sighting getSightingById(Integer id) {
        Optional<Sighting> sightings = sightingRepo.findById(id);
        Sighting toReturn = null;
        toReturn = sightings.get();
        return toReturn;
    }

    public void editSighting(Sighting toEdit) {
        sightingRepo.save(toEdit);
    }

    public void addOrg(Organization newOrg) throws DuplicateInputException {
        List<Organization> allOrganizations = orgRepo.findAll();
        for (Organization org : allOrganizations) {
            if (newOrg.getOrgName().equals(org.getOrgName())) {
                throw new DuplicateInputException("Name already exists");
            }
        }
        orgRepo.save(newOrg);
    }

    public void deleteOrg(Integer id) {
        orgRepo.deleteById(id);
    }

    public List<Organization> getAllOrganizations() {
        List<Organization> allOrganizations = orgRepo.findAll();
        return allOrganizations;
    }

    public Organization getOrgById(Integer id) {
        Optional<Organization> organizations = orgRepo.findById(id);
        Organization toReturn = null;
        toReturn = organizations.get();
        return toReturn;
    }

    public void editOrg(Organization toEdit) throws DuplicateInputException {
        List<Organization> allOrganizations = orgRepo.findAll();
        for (Organization org : allOrganizations) {
            if (toEdit.getOrgId() != org.getOrgId()) {
                if (toEdit.getOrgName().equals(org.getOrgName())) {
                    throw new DuplicateInputException("Name already exists");
                }
            }
        }
        orgRepo.save(toEdit);
    }

    public List<Location> getAllLocations() {
        List<Location> allLocations = locationRepo.findAll();
        return allLocations;
    }

    public void addLocation(Location newLocation) throws DuplicateInputException {
        List<Location> allLocations = locationRepo.findAll();
        for (Location location : allLocations) {
            if (newLocation.getLocationName().equals(location.getLocationName())) {
                throw new DuplicateInputException("Name already exists");
            }
        }
        locationRepo.save(newLocation);
    }

    public void deleteLocation(Integer id) {
        superTemp.deleteLocation(id);
    }

    public Location getLocationById(Integer id) {
        Optional<Location> locations = locationRepo.findById(id);
        Location toReturn = null;
        toReturn = locations.get();
        return toReturn;
    }

    public void editLocation(Location toEdit) throws DuplicateInputException {
        List<Location> allLocations = locationRepo.findAll();
        for (Location location : allLocations) {
            if (toEdit.getLocationId() != location.getLocationId()) {
                if (toEdit.getLocationName().equals(location.getLocationName())) {
                    throw new DuplicateInputException("Name already exists");
                }
            }
        }
        locationRepo.save(toEdit);
    }

    public List<Organization> getMatchingOrgs(String[] orgIds) {
        List<Organization> matchingOrgs = new ArrayList<>();

        if (orgIds != null) {
            for (String orgId : orgIds) {
                matchingOrgs.add(orgRepo.getOne(Integer.parseInt(orgId)));
            }

        }

        return matchingOrgs;
    }

    public List<Sighting> getRecentSightings() {
        List<Sighting> recentSightings = superTemp.getTenRecentSights();
        return recentSightings;
    }

}
