/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempDaoTest;

import com.sg.superherosightings.models.Location;
import com.sg.superherosightings.repository.LocationRep;
import java.math.BigDecimal;
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
public class LocRepInMem implements LocationRep{

    List<Location> allLocations = new ArrayList<>();
    
    public LocRepInMem(){
        
        Location locationOne = new Location();
        locationOne.setLocationId(1);
        locationOne.setLocationName("Minneapolis");
        locationOne.setLocationDesc("Cool");
        locationOne.setAddress("123 Way");
        locationOne.setLatitude(BigDecimal.valueOf(90));
        locationOne.setLongitude(BigDecimal.valueOf(180));
        
        Location locationTwo = new Location();
        locationTwo.setLocationId(2);
        locationTwo.setLocationName("New York");
        locationTwo.setLocationDesc("Uncool");
        locationTwo.setAddress("234 Drive");
        locationTwo.setLatitude(BigDecimal.valueOf(89));
        locationTwo.setLongitude(BigDecimal.valueOf(179));
        
        allLocations.add(locationOne);
        allLocations.add(locationTwo);
    }
    
    
     @Override
    public List<Location> findAll() {
        return allLocations;
    }

    @Override
    public <S extends Location> S save(S toSave) {
        int index = 0;
        
        for (int i = 0; i < allLocations.size(); i++) {
            
            Location toGet = allLocations.get(i);
            
            if (toSave.getLocationId() == toGet.getLocationId()) {
               index = i;
               allLocations.set(index, toSave);
               return toSave;
            }
        }
        
        toSave.setLocationId(allLocations.stream().mapToInt( a -> a.getLocationId() ).max().orElse(0) + 1);
        
        allLocations.add(toSave);
        
        return toSave;
    }

    @Override
    public Optional<Location> findById(Integer toFind) {
        return allLocations.stream().filter(o -> o.getLocationId() == toFind).findFirst();
    }

    @Override
    public void deleteById(Integer toDelete) {
        allLocations.removeIf(s -> s.getLocationId() == toDelete);
    }
    
    



    @Override
    public List<Location> findAll(Sort arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> findAllById(Iterable<Integer> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> List<S> saveAll(Iterable<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> S saveAndFlush(S arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Location> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getOne(Integer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> List<S> findAll(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> List<S> findAll(Example<S> arg0, Sort arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Location> findAll(Pageable arg0) {
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
    public void delete(Location arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Location> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> Optional<S> findOne(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> Page<S> findAll(Example<S> arg0, Pageable arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> long count(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Location> boolean exists(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
