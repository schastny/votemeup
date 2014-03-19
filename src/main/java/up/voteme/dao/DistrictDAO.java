package up.voteme.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import up.voteme.domain.District;
import java.util.List;

@Repository
public class DistrictDAO implements IDistrictDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long store(District district) {
		long id = 1L;
		sessionFactory.getCurrentSession().saveOrUpdate(district);
		return id;
	}

	@Override
	public void delete(Long id) {
		District district = findById(id);
		if (district != null) {
			sessionFactory.getCurrentSession().delete(district);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<District> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from District")
				.list();
	}

	@Override
	public District findById(Long Id) {
		return (District) sessionFactory.getCurrentSession().get(
				District.class, Id);
	}

}