package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Level;

public class LevelDAO {
 private EntityManagerFactory entityManagerFactory;

 public LevelDAO() {
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(Level level) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(level);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long levelId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   Level level = manager.find(Level.class, levelId);
   manager.remove(level);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public Level findById(Long levelId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(Level.class, levelId);
  } finally {
   manager.close();
  }
 }

 public List<Level> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select level from Level level");
   @SuppressWarnings("unchecked")
   List<Level> items = query.getResultList();
   for (Level item : items) {
    item.getLevel().size();
   }
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}