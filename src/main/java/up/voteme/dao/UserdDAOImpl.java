package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import up.voteme.domain.Userd;
import up.voteme.service.ProposalServiceImpl;


@Component
public class UserdDAOImpl implements UserdDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserdDAOImpl.class);
	
	@PersistenceContext
	private EntityManager em;
		

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#store(up.voteme.domain.Userd)
	 */
	@Override
	public long store(Userd item) {
		long id= em.merge(item).getUserdId();	//store-update
		return id;
	}
	
	

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#delete(long)
	 */
	@Override
	public void delete(long UserdId) {
		Userd Userd = em.find(Userd.class, UserdId);
		em.remove(Userd);
	}
		

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#findById(long)
	 */
	@Override
	public Userd findById(long UserdId) {
		 return em.find(Userd.class, UserdId);
		
	}
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#findByLogin(java.lang.String)
	 */
	@Override
	public Userd findByLogin (String login){
		TypedQuery<Userd> query = em.createQuery("SELECT u FROM Userd u WHERE u.userLogin = :name",Userd.class);
		query.setParameter("name", login);
		List<Userd> results = query.getResultList();
	    if (results.isEmpty()) return null;
	    else if (results.size() == 1) return results.get(0);
	    logger.info("NonUniqueResultException(Login must be UNIQUE)");
	    throw new NonUniqueResultException("Login must be UNIQUE");

	}

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#findAll()
	 */
	@Override
	public List<Userd> findAll() {
		TypedQuery<Userd> query = em.createQuery(
		"SELECT c FROM Userd c", Userd.class);
		List<Userd> items = query.getResultList();
		for (Userd item : items) {
			//item.getProposals().size();
		}
		return items;
	}
	
	

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserdDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("select count(*) from Userd");
		long result = (long) query.getSingleResult();
		return result;
	}



}
