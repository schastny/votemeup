package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.City;


public class CityDAO {
	private EntityManagerFactory entityManagerFactory;

	public CityDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(City item) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 long id; //stored item id
		 try {
			 tx.begin();
			 id= manager.merge(item).getCityId();	//store/update
			 tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
			 throw e;
		 } finally {
			 manager.close();
		 }
		 return id;
	}

	public void delete(Long categoryId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			City category = manager.find(City.class, categoryId);
			manager.remove(category);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	public City findById(Long cityId) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(City.class, cityId);
		 } finally {
			 manager.close();
		 }
	}

	public List<City> findAll() {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			  Query query = manager.createQuery("select c from City c");
			  @SuppressWarnings("unchecked")
			  List<City> items = query.getResultList();
			  for (City item : items) {
			  item.getDistricts().size();
			  }
		  
		  return items;
		
		 } finally {
			 manager.close();
		 }
		}
	
	public long countAll() {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			  Query query = manager.createQuery("select count(*) from City");
			  long result = (long) query.getSingleResult();
			  return result;
		 } finally {
			 manager.close();
		 }
	}
}