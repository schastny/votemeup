package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Comment;


public class CommentDAO {
	private EntityManagerFactory entityManagerFactory;

	public CommentDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate");
	}

	public void store(Comment item) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 long id = item.getCommentId(); //stored item id
		 try {
			  tx.begin();
			  if( id == 0){			 //create
					 manager.persist(item);
					 id = item.getCommentId();
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
	}

	public void delete(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 EntityTransaction tx = manager.getTransaction();
		 try {
			  tx.begin();
			  Comment com = manager.find(Comment.class, Id);
			  manager.remove(com);
			  tx.commit();
		 } catch (RuntimeException e) {
			 tx.rollback();
		  throw e;
		 } finally {
			 manager.close();
		 }
	}

	public Comment findById(Long Id) {
		 EntityManager manager = entityManagerFactory.createEntityManager();
		 try {
			 return manager.find(Comment.class, Id);
		 } finally {
			 manager.close();
		 }
	}

	public List<Comment> findAll() {
	 EntityManager manager = entityManagerFactory.createEntityManager();
	 try {
		  Query query = manager.createQuery("select com from Comment com");
		  @SuppressWarnings("unchecked")
		  List<Comment> items = query.getResultList();
		  //for (Comment item : items) {
		  //item.getProjects().size();
		  //}
	  
	  return items;

	 } finally {
		 manager.close();
	 }
	}
}
