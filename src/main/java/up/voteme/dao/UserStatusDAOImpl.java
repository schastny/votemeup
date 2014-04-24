package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import up.voteme.domain.UserStatus;


@Component
public class UserStatusDAOImpl implements UserStatusDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(UserStatusDAOImpl.class);
	
	@PersistenceContext
	private EntityManager em;
		

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserStatusDAO#store(up.voteme.domain.UserStatus)
	 */
	@Override
	public long store(UserStatus item) {
		long id= em.merge(item).getId();	//store-update
		return id;
	}
	
	


	/* (non-Javadoc)
	 * @see up.voteme.dao.UserStatusDAO#delete(long)
	 */
	@Override
	public void delete(long UserStatusId) {
		UserStatus UserStatus = em.find(UserStatus.class, UserStatusId);
		em.remove(UserStatus);
	}
		

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserStatusDAO#findById(long)
	 */
	@Override
	public UserStatus findById(long UserStatusId) {
		UserStatus item = em.find(UserStatus.class, UserStatusId);
		return item;
	}



	/* (non-Javadoc)
	 * @see up.voteme.dao.UserStatusDAO#findAll()
	 */
	@Override
	public List<UserStatus> findAll() {
		TypedQuery<UserStatus> query = em.createQuery(
		"SELECT c FROM UserStatus c", UserStatus.class);
		List<UserStatus> items = query.getResultList();
		return items;
	}
	
	

	/* (non-Javadoc)
	 * @see up.voteme.dao.UserStatusDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("select count(*) from UserStatus");
		long result = (long) query.getSingleResult();
		return result;
	}



}

