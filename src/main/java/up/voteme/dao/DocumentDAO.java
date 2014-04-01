package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Document;

public class DocumentDAO {
	private EntityManagerFactory entityManagerFactory;

	public DocumentDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(Document item) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 long id; //stored item id
		 try {
			 tx.begin();
			 id= manager.merge(item).getDocId();	//store/update
			 tx.commit();
		 } catch (RuntimeException e) {
			 System.out.println("Persist fail "+e);
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
			  Document com = manager.find(Document.class, Id);
			  manager.remove(com);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Document findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Document.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Document> findAll() {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			  Query query = manager.createQuery("select d from Document d");
			  @SuppressWarnings("unchecked")
			  List<Document> items = query.getResultList();
			  //for (Category item : items) {
			  // item.getProjects().size();
			  //}
			  
			  return items;
	
		 } finally {
			 manager.close();
		 }
		}
}
