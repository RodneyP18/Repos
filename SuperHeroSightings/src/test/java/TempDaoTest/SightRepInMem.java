/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempDaoTest;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.models.Sighting;
import com.sg.superherosightings.repository.SightingRep;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Buddy
 */
public class SightRepInMem implements SightingRep {

    List<Sighting> allSightings = new ArrayList<>();

    public SightRepInMem() {
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
    
    @Override
    public <S extends Sighting> S save(S toSave) {
        
        toSave.setSightingId(allSightings.stream().mapToInt( a -> a.getSightingId() ).max().orElse(0) + 1);
        
        allSightings.add(toSave);
        
        return toSave;
    }

    @Override
    public Optional<Sighting> findById(Integer toFind) {
        return allSightings.stream().filter(o -> o.getSightingId() == toFind).findFirst();
    }

    @Override
    public List<Sighting> findAll() {
        return allSightings;
    }
    
     @Override
    public void deleteById(Integer toDelete) {
        allSightings.removeIf(s -> s.getSightingId() == toDelete);
        
    }
    
    
    

    @Override
    public List<Sighting> findAll(Sort arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sighting> findAllById(Iterable<Integer> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> List<S> saveAll(Iterable<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> S saveAndFlush(S arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Sighting> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sighting getOne(Integer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> List<S> findAll(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> List<S> findAll(Example<S> arg0, Sort arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Sighting> findAll(Pageable arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Integer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Sighting arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Sighting> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> Optional<S> findOne(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> Page<S> findAll(Example<S> arg0, Pageable arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> long count(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Sighting> boolean exists(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
