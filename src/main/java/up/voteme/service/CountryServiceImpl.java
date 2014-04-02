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
private CountryDAO countryDAO;

	@Transactional
	@Override
	public void store(Country country) {
		countryDAO.store(country);

	}

	@Transactional
	@Override
	public void delete(Long id) {
		countryDAO.delete(id);

	}

	@Transactional
	@Override
	public Country findById(Long id) {		
		return  countryDAO.findById(id);
	}

	@Transactional
	@Override
	public List<Country> findAll() {		
		return  countryDAO.findAll();
	}

	@Override
	@Transactional
	public long getCount() {
		return countryDAO.countAll();
	}
}
