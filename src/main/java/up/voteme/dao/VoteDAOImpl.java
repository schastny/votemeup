package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Vote;

@Component
public class VoteDAOImpl implements VoteDAO {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public long store(Vote vote) {
		long id= em.merge(vote).getVoteId();	//store-update
		return id;
	}

	@Override
	public void delete(long id) {
		Vote vote = em.find(Vote.class, id);
		em.remove(vote);

	}

	@Override
	public Vote findById(long id) {
		 return em.find(Vote.class, id);
	}

	@Override
	public List<Vote> findAll() {
		TypedQuery<Vote> query = em.createQuery(
		"SELECT c FROM Vote c", Vote.class);
		List<Vote> items = query.getResultList();
		return items;
	}

	@Override
	public long countAll() {
		  Query query = em.createQuery("SELECT COUNT(*) FROM Vote");
		  long count = (long) query.getSingleResult();
		  return count;
	}

	@Override
	public long countVoteByProposal(long id) {
		  Query query = em.createQuery("SELECT COUNT(*) FROM Vote AS v WHERE v.proposal = :id");
		  long count = (long) query.getSingleResult();
		  return count;
	}

}
