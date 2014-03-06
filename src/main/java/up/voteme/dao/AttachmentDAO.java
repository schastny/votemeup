package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Attachment;

public class AttachmentDAO {
 private EntityManagerFactory entityManagerFactory;

 public AttachmentDAO() {
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(Attachment attachment) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(attachment);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long attachmentId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   Attachment attachment = manager.find(Attachment.class, attachmentId);
   manager.remove(attachment);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public Attachment findById(Long attachmentId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(Attachment.class, attachmentId);
  } finally {
   manager.close();
  }
 }

 public List<Attachment> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select attachment from Attachment attachment");
   @SuppressWarnings("unchecked")
   List<Attachment> items = query.getResultList();
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}