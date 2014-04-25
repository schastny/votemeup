package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Role;
import up.voteme.domain.Role;
import up.voteme.domain.Userd;


@Component
public class RoleDAOImpl implements RoleDAO {
	@PersistenceContext
	EntityManager em;
	

	/* (non-Javadoc)
	 * @see up.voteme.dao.RoleDAO#store(up.voteme.domain.Role)
	 */
	@Override
	public long store(Role item) {
		long id= em.merge(item).getRoleId();	//store-update
		return id;
	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.RoleDAO#delete(long)
	 */
	@Override
	public void delete(long RoleId) {
		Role Role = em.find(Role.class, RoleId);
		em.remove(Role);
	}


	/* (non-Javadoc)
	 * @see up.voteme.dao.RoleDAO#findById(long)
	 */
	@Override
	public Role findById(long RoleId) {
		return em.find(Role.class, RoleId);
	}


	/* (non-Javadoc)
	 * @see up.voteme.dao.RoleDAO#findAll()
	 */
	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createQuery("SELECT c FROM Role c", Role.class);
		List<Role> items = query.getResultList();
		for (Role item : items) {
			//
		}
		return items;
	}
	

	/* (non-Javadoc)
	 * @see up.voteme.dao.RoleDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("SELECT count(*) FROM Role");
		long result = (long) query.getSingleResult();
		return result;
	}
	
	public Role findByName (String name){
		TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r WHERE r.roleName = :name", Role.class);
		query.setParameter("name", name);
		List<Role> results = query.getResultList();
	    if (results.isEmpty()) return null;
	    else if (results.size() == 1) return results.get(0);
	    //logger.info("NonUniqueResultException(Login must be UNIQUE)");
	    throw new NonUniqueResultException("Login must be UNIQUE");
	}
	
}
