package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void store(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);		
	}

	@Override
	public void deleteById(Long id) {		
		Role role = findById(id);		
		if (null != role) {
			sessionFactory.getCurrentSession().delete(role);
		}
	}
	
	@Override
	public Role findById(Long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}
	
}
