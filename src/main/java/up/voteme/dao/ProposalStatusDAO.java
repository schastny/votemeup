package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.ProposalStatus;

public class ProposalStatusDAO {
	private EntityManagerFactory entityManagerFactory;

	public ProposalStatusDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(ProposalStatus item) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 long id; //stored item id
		 try {
			 tx.begin();
			 id= manager.merge(item).getId();	//store/update
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
			  ProposalStatus com = manager.find(ProposalStatus.class, Id);
			  manager.remove(com);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public ProposalStatus findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(ProposalStatus.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<ProposalStatus> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select com from ProposalStatus com");
		  @SuppressWarnings("unchecked")
		  List<ProposalStatus> items = query.getResultList();
		  //for (ProposalStatus item : items) {
		  //item.getProjects().size();
		  //}
	  
	  return items;

	 } finally {
		 manager.close();
	 }
	}

	public long countPS() {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			  Query query = manager.createQuery("SELECT COUNT(*) FROM ProposalStatus ps");
			  long count = (long) query.getSingleResult();
			  
			  return count;

		 } finally {
			 manager.close();
		 }
		}

}

