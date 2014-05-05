package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.District;


@Component
public class DistrictDAOImpl implements IDistrictDAO {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public long store(District district) {
		long id = manager.merge(district).getDistrictId();	
		return id;
	}

	@Override
	public void delete(Long id) {
		District district = manager.find(District.class,id);
		manager.remove(district);
	}

	@Override
	public List<District> findAll() {
		 TypedQuery<District> query = manager.createQuery("SELECT d FROM District d", District.class);
		  List<District> district = query.getResultList();
	  return district;
	}

	@Override
	public District findById(Long id) {
		return manager.find(District.class, id);
	}

	@Override
	public List<District> getByCityId(long id) {
		TypedQuery<District> query = manager.createQuery(
		"SELECT d FROM District d WHERE d.city.id = " + id, District.class);
		List<District> items = query.getResultList();
		return items;
	}


}