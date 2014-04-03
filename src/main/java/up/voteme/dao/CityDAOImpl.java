package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.City;

@Component
public class CityDAOImpl implements CityDAO {
	
	@PersistenceContext
	EntityManager em;
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#store(up.voteme.domain.City)
	 */
	@Override
	public long store(City item) {
		long id= em.merge(item).getCityId();	//store-update
		return id;
	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#delete(java.lang.Long)
	 */
	@Override
	public void delete(long cityId) {
		City city = em.find(City.class, cityId);
		em.remove(city);
	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#findById(java.lang.Long)
	 */
	@Override
	public City findById(long cityId) {
		return em.find(City.class, cityId);
	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#findAll()
	 */
	@Override
	public List<City> findAll() {
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c", City.class);
		List<City> items = query.getResultList();
		for (City item : items) {
			item.getDistricts().size();
		}
		return items;
	}
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("SELECT count(*) FROM City");
		long result = (long) query.getSingleResult();
		return result;
	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.CityDAO#getByRegionId(java.lang.Long)
	 */
	@Override
	public List<City> getByRegionId(long id) {
		TypedQuery<City> query = em.createQuery(
		"SELECT c FROM City c WHERE c.region.id = " + id, City.class);
		List<City> items = query.getResultList();
		return items;
	}

}