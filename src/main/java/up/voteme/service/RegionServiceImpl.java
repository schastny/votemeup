package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.RegionDAO;
import up.voteme.domain.Region;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionDAO regionDAO;

	@Override
	@Transactional
	public long store(Region region) {
		return regionDAO.store(region);
	}
	

	@Override
	@Transactional
	public void delete(long id) {
		regionDAO.delete(id);	
	}

	@Override
	@Transactional
	public List<Region> getAllRegion() {
		return regionDAO.findAll();
	}

	@Override
	@Transactional
	public Region getById(long id) {
		return regionDAO.findById(id);
	}

	@Override
	@Transactional
	public long getCount() {
		return regionDAO.countAll();
	}

	@Override
	@Transactional
	public List<Region> getByCountryId(long id) {
		return regionDAO.getByCountryId(id);
	}

}
