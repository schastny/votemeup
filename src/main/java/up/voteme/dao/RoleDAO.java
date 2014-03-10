package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Role;



public class RoleDAO {
	private EntityManagerFactory entityManagerFactory;

	public RoleDAO() {
	 entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public long store(Role item) {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 EntityTransaction tx = manager.getTransaction();
	 long id; //stored item id
	 try {
		 tx.begin();
		 id= manager.merge(item).getRoleId();	//store/update
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
			  Role item = manager.find(Role.class, Id);
			  manager.remove(item);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Role findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Role.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Role> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select r from Role r");
		  @SuppressWarnings("unchecked")
		  List<Role> items = query.getResultList();
		  //Collections are lazy-load by default
		  // alternative is @OneToMany(fetch = FetchType.EAGER)
		  for (Role item : items) {
			  	item.getUsers().size();
			 // item.getCategories().size();
			//  item.getDocuments().size();
			//  item.getVotes().size();
		  }
		  return items;
	 } finally {
		 manager.close();
	 }
	}
}
