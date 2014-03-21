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

	@Transactional
	@Override
	public void store(District district) {
		districtDAO.store(district);

	}
	@Transactional
	@Override
	public void delete(Long id) {
		districtDAO.delete(id);

	}
	@Transactional
	@Override
	public District findById(Long id) {		
		return  districtDAO.findById(id);
	}
	@Transactional
	@Override
	public List<District> findAll() {		
		return  districtDAO.findAll();
	}

}
