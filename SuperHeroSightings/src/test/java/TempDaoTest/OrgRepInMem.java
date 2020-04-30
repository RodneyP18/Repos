/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempDaoTest;

import com.sg.superherosightings.models.Hero;
import com.sg.superherosightings.models.Organization;
import com.sg.superherosightings.models.Power;
import com.sg.superherosightings.repository.OrganizationRep;
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
public class OrgRepInMem implements OrganizationRep{
    
    List<Organization> allOrgs = new ArrayList<>();
    
    public OrgRepInMem(){
        List<Hero> heroListOne = new ArrayList<>();
        List<Hero> heroListTwo = new ArrayList<>();
        
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
        
        heroListOne.add(heroOne);
        heroListTwo.add(heroTwo);
        
        Organization orgOne = new Organization();
        orgOne.setOrgId(1);
        orgOne.setOrgName("SG");
        orgOne.setOrgDesc("Super");
        orgOne.setAddress("345 Way");
        orgOne.setEmail("sg.com");
        orgOne.setPhone("123-324-3456");
        orgOne.setMembers(heroListOne);
        
        Organization orgTwo = new Organization();
        orgTwo.setOrgId(2);
        orgTwo.setOrgName("SHS");
        orgTwo.setOrgDesc("Semi-Super");
        orgTwo.setAddress("456 Drive");
        orgTwo.setEmail("shs.com");
        orgTwo.setPhone("234-345-4567");
        orgTwo.setMembers(heroListTwo);
        
        allOrgs.add(orgOne);
        allOrgs.add(orgTwo);
    }
    
     @Override
    public <S extends Organization> S save(S toSave) {
        int index = 0;
        
        for (int i = 0; i < allOrgs.size(); i++) {
            
            Organization toGet = allOrgs.get(i);
            
            if (toSave.getOrgId() == toGet.getOrgId()) {
               index = i;
               allOrgs.set(index, toSave);
               return toSave;
            }
        }
        
        toSave.setOrgId(allOrgs.stream().mapToInt( a -> a.getOrgId() ).max().orElse(0) + 1);
        
        allOrgs.add(toSave);
        
        return toSave;
    }

    @Override
    public Optional<Organization> findById(Integer toFind) {
        
        return allOrgs.stream().filter(o -> o.getOrgId() == toFind).findFirst();
           
    }

    @Override                                                               
    public List<Organization> findAll() {
        return allOrgs;
    }
    
    @Override
    public void deleteById(Integer toDelete) {
        allOrgs.removeIf(s -> s.getOrgId() == toDelete);
    }
    
    
    
    

    @Override
    public List<Organization> findAll(Sort arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organization> findAllById(Iterable<Integer> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> List<S> saveAll(Iterable<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> S saveAndFlush(S arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(Iterable<Organization> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organization getOne(Integer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> List<S> findAll(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> List<S> findAll(Example<S> arg0, Sort arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<Organization> findAll(Pageable arg0) {
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
    public void delete(Organization arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends Organization> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> Optional<S> findOne(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> Page<S> findAll(Example<S> arg0, Pageable arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> long count(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends Organization> boolean exists(Example<S> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
