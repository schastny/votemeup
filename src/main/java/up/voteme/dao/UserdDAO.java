package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Userd;

public class UserdDAO {
	private EntityManagerFactory entityManagerFactory;

	public UserdDAO() {
	 entityManagerFactory = Persistence.createEntityManagerFactory("default");
	}

	public long store(Userd item) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 EntityTransaction tx = manager.getTransaction();
	 long id; //stored item id
	 try {
		 tx.begin();
		 id= manager.merge(item).getUserdId();	//store/update
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
			  Userd item = manager.find(Userd.class, Id);
			  manager.remove(item);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Userd findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Userd.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Userd> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select r from Userd r");
		  @SuppressWarnings("unchecked")
		  List<Userd> items = query.getResultList();
		  //Collections are lazy-load by default
		  // alternative is @OneToMany(fetch = FetchType.EAGER)
		  for (Userd item : items) {
			  	item.getCommentd().size();
			  	item.getProposals().size();
			  	item.getVotes().size();
		  }
		  return items;
	 } finally {
		 manager.close();
	 }
	}
}
