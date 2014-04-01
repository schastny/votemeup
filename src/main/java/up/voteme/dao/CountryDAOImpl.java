package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import up.voteme.domain.Country;

@Component
public class CountryDAOImpl implements CountryDAO {
	
	@PersistenceContext
	EntityManager eMgr;
	
	@Override
	public long store(Country item) {                 // store record
		long Id = eMgr.merge(item).getCountryId();
		return Id;
	}

	@Override
	public void delete(long CountryId) {              // delete record
		Country Country = eMgr.find(Country.class, CountryId);
		eMgr.remove(Country);
	}

	@Override
	public Country findById(long CountryId) {         // find record
		return eMgr.find(Country.class, CountryId);
	}

	@Override
	public List<Country> findAll() {                  // select all records
		TypedQuery<Country> query = eMgr.createQuery("SELECT c FROM Country c", Country.class);
		List<Country> items = query.getResultList();
		for (Country item : items) {
			System.out.println(item);
		}
		return items;
	}
	
	@Override
	public long countAll() {                          // return records count
		Query query = eMgr.createQuery("SELECT COUNT(*) FROM Country");
		long result = (long) query.getSingleResult();
		return result;
	}
}