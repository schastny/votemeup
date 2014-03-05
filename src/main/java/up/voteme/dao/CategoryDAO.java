package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Category;

public class CategoryDAO {

private EntityManagerFactory entityManagerFactory;

public CategoryDAO() {
	entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
}

public long store(Category item) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 EntityTransaction tx = manager.getTransaction();
	 long id = item.getCategId(); //stored item id
	 try {
		 tx.begin();
		 if( id == 0){			 //create
			 manager.persist(item);
			 id = item.getCategId();
		 } else {
			 manager.merge(item);//update
		 }
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
		Category category = manager.find(Category.class, categoryId);
		manager.remove(category);
		tx.commit();
	} catch (RuntimeException e) {
		tx.rollback();
		throw e;
	} finally {
		manager.close();
	}
}

public Category findById(Long categoryId) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		 return manager.find(Category.class, categoryId);
	 } finally {
		 manager.close();
	 }
}

public List<Category> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select c from Category c");
		  @SuppressWarnings("unchecked")
		  List<Category> items = query.getResultList();
		  for (Category item : items) {
		  item.getProposals().size();
		  }
	  
	  return items;
	
	 } finally {
		 manager.close();
	 }
	}
}