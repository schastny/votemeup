package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Country;

public class CountryDAO {
	
		private EntityManagerFactory entityManagerFactory;

		public CountryDAO() {
			entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
		}

		public long store(Country item) {
			 EntityManager manager = entityManagerFactory.createEntityManager();
			 EntityTransaction tx = manager.getTransaction();
			 long id; //stored item id
			 try {
				 tx.begin();
				 id= manager.merge(item).getCountryId();	//store/update
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
				  Country com = manager.find(Country.class, Id);
				  manager.remove(com);
				  tx.commit();
			 } catch (RuntimeException e) {
				 tx.rollback();
			  throw e;
			 } finally {
				 manager.close();
			 }
		}

		public Country findById(Long Id) {
			 EntityManager manager = entityManagerFactory.createEntityManager();
			 try {
				 return manager.find(Country.class, Id);
			 } finally {
				 manager.close();
			 }
		}

		public List<Country> findAll() {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			  Query query = manager.createQuery("select com from Country com");
			  @SuppressWarnings("unchecked")
			  List<Country> items = query.getResultList();
			  for (Country item : items) {
				  item.getRegions().size();
			  }
		  
		  return items;

		 } finally {
			 manager.close();
		 }
		}
	}