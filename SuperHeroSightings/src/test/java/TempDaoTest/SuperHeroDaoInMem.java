/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TempDaoTest;

import com.sg.superherosightings.dao.SuperHeroDao;
import com.sg.superherosightings.models.Sighting;
import java.util.List;

/**
 *
 * @author Buddy
 */
public class SuperHeroDaoInMem implements SuperHeroDao{

    @Override
    public List<Sighting> getTenRecentSights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
