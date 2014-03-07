package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Proposal;

public class ProposalDAO {
	private EntityManagerFactory entityManagerFactory;

	public ProposalDAO() {
	 entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(Proposal item) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 EntityTransaction tx = manager.getTransaction();
	 long id; //stored item id
	 try {
		 tx.begin();
		 id= manager.merge(item).getProposalId();	//store/update
		 tx.commit();
	 } catch (RuntimeException e) {
		 System.out.println("persist failed "+e); 
		 tx.rollback();
		 throw e;
	 } finally {
		 manager.close();
	 }
	 return id;
	 
	}

	public void delete(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 try {
			  tx.begin();
			  Proposal item = manager.find(Proposal.class, Id);
			  manager.remove(item);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Proposal findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 Proposal item = manager.find(Proposal.class, Id);
			 
			 return item;
		 } finally {
			 manager.close();
		 }
	}

	public List<Proposal> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select p from Proposal p");
		  @SuppressWarnings("unchecked")
		  List<Proposal> items = query.getResultList();
		  //Collections are lazy-load by default
		  // alternative is @OneToMany(fetch = FetchType.EAGER)
		  for (Proposal item : items) {
			  item.getComments().size();
			  item.getCategories().size();
			  item.getDocuments().size();
			  item.getVotes().size();
		  }
		  return items;
	 } finally {
		 manager.close();
	 }
	}
}
