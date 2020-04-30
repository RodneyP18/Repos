/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempDaoTest;

import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.repository.PowerRep;
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
public class PowerRepInMem implements PowerRep{
    
    List<Power> allPowers = new ArrayList<>();
    
    public PowerRepInMem(){
        
        Power powerOne = new Power();
        powerOne.setPowerId(1);
        powerOne.setSuperPower("Flying");
        
        Power powerTwo = new Power();
        powerTwo.setPowerId(2);
        powerTwo.setSuperPower("Speed");
        
        allPowers.add(powerOne);
        allPowers.add(powerTwo);
    }
    
    @Override
    public <S extends Power> S save(S toSave) {
        int index = 0;
        
        for (int i = 0; i < allPowers.size(); i++) {
            
            Power toGet = allPowers.get(i);
            
            if (toSave.getPowerId() == toGet.getPowerId()) {
               index = i;
               allPowers.set(index, toSave);
               return toSave;
            }
        }
        
        toSave.setPowerId(allPowers.stream().mapToInt( a -> a.getPowerId() ).max().orElse(0) + 1);
        
        allPowers.add(toSave);
        
        return toSave;
    }

    @Override
    public Optional<Power> findById(Integer toFind) {
        return allPowers.stream().filter(o -> o.getPowerId() == toFind).findFirst();
    }

    @Override
    public List<Power> findAll() {
        return allPowers;
    }
    
    @Override
    public void deleteById(Integer toDelete) {
        allPowers.removeIf(s -> s.getPowerId() == toDelete);
    }
    
    
    
    
    

    @Override
    public List<Power> findAll(Sort arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Power> findAllById(Iterable<Integer> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> List<S> saveAll(Iterable<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> S saveAndFlush(S arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Power> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power getOne(Integer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> List<S> findAll(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> List<S> findAll(Example<S> arg0, Sort arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Power> findAll(Pageable arg0) {
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
    public void delete(Power arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Power> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> Optional<S> findOne(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> Page<S> findAll(Example<S> arg0, Pageable arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> long count(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Power> boolean exists(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
