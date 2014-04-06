package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Region;

@Component
public class RegionDAOImpl implements RegionDAO {

	@PersistenceContext
    private EntityManager em;

	
	@Override
	public long store(Region region) {
		long id= em.merge(region).getRegionId();	//store-update
		return id;
	}
	
	
	@Override
	public void delete(long id) {
		Region region = em.find(Region.class, id);
		em.remove(region);

	}
	
	
	@Override
	public Region findById(long id) {
		 return em.find(Region.class, id);
	}
	
	
	@Override
	public List<Region> findAll() {
		TypedQuery<Region> query = em.createQuery(
		"SELECT c FROM Region c", Region.class);
		List<Region> items = query.getResultList();
		return items;
	}
	
	
	@Override
	public long countAll() {
		  Query query = em.createQuery("SELECT COUNT(*) FROM Region");
		  long count = (long) query.getSingleResult();
		  return count;
	}

	@Override
	public List<Region> getByCountryId(long id) {
		TypedQuery<Region> query = em.createQuery(
		"SELECT r FROM Region r WHERE r.country.id = " + id, Region.class);
		List<Region> items = query.getResultList();
		for (Region r :items){
			r.getCities().size();
		}
		return items;
	}

}
