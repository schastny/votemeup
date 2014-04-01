package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.ProposalStatus;

@Component
public class ProposalStatusDAOImpl implements ProposalStatusDAO {

	@PersistenceContext
    private EntityManager em;

	@Override
	public long store(ProposalStatus item) {
		long id= em.merge(item).getId();	//store-update
		return id;
	}
	
	@Override
	public void delete(long id) {
		ProposalStatus ps = em.find(ProposalStatus.class, id);
		em.remove(ps);
	}

	@Override
	public ProposalStatus findById(long id) {
		 return em.find(ProposalStatus.class, id);
		
	}

	@Override
	public List<ProposalStatus> findAll() {
		TypedQuery<ProposalStatus> query = em.createQuery(
		"SELECT c FROM ProposalStatus c", ProposalStatus.class);
		List<ProposalStatus> items = query.getResultList();
		return items;
	}

	@Override
	public long countAll() {
		  Query query = em.createQuery("SELECT COUNT(*) FROM ProposalStatus ps");
		  long count = (long) query.getSingleResult();
		  return count;
	}


}
