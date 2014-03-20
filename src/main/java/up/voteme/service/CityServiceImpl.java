package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.CityDAO;
import up.voteme.domain.City;

@Service
public class CityServiceImpl implements CityService {
	
	 	@Autowired
	    private CityDAO cityDAO;
	    
	    
	    /* (non-Javadoc)
		 * @see up.voteme.service.CityService#getAll()
		 */
	    @Override
		@Transactional
		public List<City> getAll() {
	        return cityDAO.findAll();
	    }
	    
	    
		/* (non-Javadoc)
		 * @see up.voteme.service.CityService#delete(long)
		 */
		@Override
		@Transactional
	    public void delete(long id) {
	    	cityDAO.delete(id);
		}
}
