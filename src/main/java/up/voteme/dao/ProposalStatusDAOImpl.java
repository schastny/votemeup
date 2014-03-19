package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import up.voteme.domain.ProposalStatus;

@Component
public class ProposalStatusDAOImpl implements ProposalStatusDAO {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public long store(ProposalStatus proposalStatus) {
		 EntityTransaction tx = em.getTransaction();
		 long id; //stored item id
		 try {
			 tx.begin();
			 id= em.merge(proposalStatus).getId();	//store/update
			 tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 em.close();
		 }
		 return id;	}

	@Override
	public void delete(long id) {
		 EntityTransaction tx = em.getTransaction();
		 try {
			  tx.begin();
			  ProposalStatus com = em.find(ProposalStatus.class, id);
			  em.remove(com);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 em.close();
		 }

	}

	@Override
	public ProposalStatus findById(long id) {
		 try {
			 return em.find(ProposalStatus.class, id);
		 } finally {
			 em.close();
		 }

	}

	@Override
	public List<ProposalStatus> getAllPS() {
		 try {
			  Query query = em.createQuery("select com from ProposalStatus com");
			  @SuppressWarnings("unchecked")
			  List<ProposalStatus> items = query.getResultList();
			  //for (ProposalStatus item : items) {
			  //item.getProjects().size();
			  //}
		  
		  return items;

		 } finally {
			 em.close();
		 }

	}

	@Override
	public long countPS() {
		 try {
			  Query query = em.createQuery("SELECT COUNT(*) FROM ProposalStatus ps");
			  long count = (long) query.getSingleResult();
			  
			  return count;

		 } finally {
			 em.close();
		 }

	}

}
