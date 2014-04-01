package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.CountryDAO;
import up.voteme.domain.Country;

@Service
public class CountryServiceImpl implements CountryService {

@Autowired
private CountryDAO CountryDAO;

	@Transactional
	@Override
	public void store(Country Country) {
		CountryDAO.store(Country);

	}

	@Transactional
	@Override
	public void delete(Long id) {
		CountryDAO.delete(id);

	}

	@Transactional
	@Override
	public Country findById(Long id) {		
		return  CountryDAO.findById(id);
	}

	@Transactional
	@Override
	public List<Country> findAll() {		
		return  CountryDAO.findAll();
	}

	@Override
	@Transactional
	public long getCount() {
		return CountryDAO.countAll();
	}
}
