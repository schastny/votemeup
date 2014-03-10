package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Vote;

public class VoteDAO {
	private EntityManagerFactory entityManagerFactory;

	public VoteDAO() {
	 entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(Vote item) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 EntityTransaction tx = manager.getTransaction();
	 long id; //stored item id
	 try {
		 tx.begin();
		 id= manager.merge(item).getVoteId();	//store/update
		 tx.commit();
	 } catch (RuntimeException e) {
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
			  Vote item = manager.find(Vote.class, Id);
			  manager.remove(item);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Vote findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Vote.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Vote> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select r from Vote r");
		  @SuppressWarnings("unchecked")
		  List<Vote> items = query.getResultList();
		  //Collections are lazy-load by default
		  // alternative is @OneToMany(fetch = FetchType.EAGER)
		  //for (Vote item : items) {
			//  item.getVotes().size();
		  //}
		  return items;
	 } finally {
		 manager.close();
	 }
	}
}
