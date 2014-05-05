package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Country;
import up.voteme.domain.Country;

@Component
public class CountryDAOImpl implements CountryDAO {

	@PersistenceContext
	private EntityManager eMgr;

	@Override
	public long store(Country item) {                 // store record
		long Id = eMgr.merge(item).getCountryId();
		return Id;
	}

	@Override
	public void delete(long countryId) {              // delete record
		Country country = eMgr.find(Country.class, countryId);
		eMgr.remove(country);
	}

	@Override
	public Country findById(long countryId) {         // find record
System.out.println("countryID !!! = "+countryId);
		Country con = new Country();

		con = eMgr.find(Country.class, countryId);

System.out.println("country = "+con);		

		return con;
		//return eMgr.find(Country.class, countryId);
	}

	@Override
	public List<Country> findAll() {                  // select all records
		TypedQuery<Country> query = eMgr.createQuery("SELECT c FROM Country c", Country.class);
		List<Country> items = query.getResultList();
		for (Country item : items) {
			//System.out.println(item);
			item.getRegions().size();
		}
		return items;
	}

	@Override
	public long countAll() {                          // return records count
		Query query = eMgr.createQuery("SELECT COUNT(*) FROM Country");
		long result = (long) query.getSingleResult();
		return result;
	}

	public Country findByName (String name){
		TypedQuery<Country> query = eMgr.createQuery("SELECT r FROM Country r WHERE r.countryName = :name", Country.class);
		query.setParameter("name", name);
		List<Country> results = query.getResultList();
	    if (results.isEmpty()) return null;
	    else if (results.size() == 1) return results.get(0);
	    throw new NonUniqueResultException("Country must be UNIQUE");
	}
}