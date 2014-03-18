package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Userd;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void store(Userd user) {		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}	
	
	@Override
	public void deleteById(Long id) {		
		Userd user = findById(id);		
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}
	
	@Override
	public Userd findById(Long id) {
		return (Userd) sessionFactory.getCurrentSession().get(Userd.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Userd> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Userd").list();
	}
	
}