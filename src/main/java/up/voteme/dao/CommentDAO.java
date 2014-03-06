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
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(Comment comment) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(comment);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long commentId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   Comment comment = manager.find(Comment.class, commentId);
   manager.remove(comment);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public Comment findById(Long commentId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(Comment.class, commentId);
  } finally {
   manager.close();
  }
 }

 public List<Comment> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select comment from Comment comment");
   @SuppressWarnings("unchecked")
   List<Comment> items = query.getResultList();
   for (Comment item : items) {
    item.getComment().size();
   }
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}