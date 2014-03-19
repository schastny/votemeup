package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Region;

public class RegionDAOOld {
	private EntityManagerFactory entityManagerFactory;

	public RegionDAOOld() {
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(Region item) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 long id; //stored item id
		 try {
			 tx.begin();
			 id= manager.merge(item).getRegionId();	//store/update
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
			  Region com = manager.find(Region.class, Id);
			  manager.remove(com);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Region findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Region.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Region> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select com from Region com");
		  @SuppressWarnings("unchecked")
		  List<Region> items = query.getResultList();
		  for (Region item : items) {
			  item.getCities().size();
		  }
	  
	  return items;

	 } finally {
		 manager.close();
	 }
	}
}
