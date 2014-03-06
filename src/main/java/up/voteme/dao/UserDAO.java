package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.User;

public class UserDAO {
 private EntityManagerFactory entityManagerFactory;

 public UserDAO() {
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(User user) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(user);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long userId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   User user = manager.find(User.class, userId);
   manager.remove(user);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public User findById(Long userId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(User.class, userId);
  } finally {
   manager.close();
  }
 }

 public List<User> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select user from User user");
   @SuppressWarnings("unchecked")
   List<User> items = query.getResultList();
   for (User item : items) {
    item.getUser().size();
   }
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}