package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;

@Component
public class ProposalDAOImpl implements ProposalDAO {
	

	@PersistenceContext
	private EntityManager em;
		
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#store(up.voteme.domain.Proposal)
	 */
	@Override
	public long store(Proposal item) {
		long id= em.merge(item).getProposalId();	//store-update
		return id;
	}
	
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#delete(long)
	 */
	@Override
	public void delete(long id) {
		Proposal proposal = em.find(Proposal.class, id);
		em.remove(proposal);
	}
		
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#findById(long)
	 */
	@Override
	public Proposal findById(long categoryId) {
		 return em.find(Proposal.class, categoryId);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#findAll()
	 */
	@Override
	public List<Proposal> findAll() {
		TypedQuery<Proposal> query = em.createQuery(
		"SELECT p FROM Proposal p", Proposal.class);
		List<Proposal> items = query.getResultList();
		for (Proposal item : items) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return items;
	}
	
	public List<Proposal> findAllbyDate() {
		TypedQuery<Proposal> query = em.createQuery(
		"SELECT p FROM Proposal p ORDER BY creation_date", Proposal.class);
		List<Proposal> items = query.getResultList();
		for (Proposal item : items) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return items;
	}
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("select count(*) from Proposal");
		long result = (long) query.getSingleResult();
		return result;
	}
}