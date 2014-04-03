package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.IDistrictDAO;
import up.voteme.domain.District;

@Service
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private IDistrictDAO districtDAO;

	@Override
	@Transactional
	public void store(District district) {
		districtDAO.store(district);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		districtDAO.delete(id);

	}

	@Override
	@Transactional
	public District findById(Long id) {		
		return  districtDAO.findById(id);
	}

	@Override
	@Transactional
	public List<District> findAll() {		
		return  districtDAO.findAll();
	}

	@Override
	@Transactional
	public List<District> getByCityId(long id) {
		return districtDAO.getByCityId(id);
	}


}
