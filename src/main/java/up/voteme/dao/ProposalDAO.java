package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.Proposal;

public class ProposalDAO {
 private EntityManagerFactory entityManagerFactory;

 public ProposalDAO() {
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(Proposal proposal) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(proposal);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long proposalId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   Proposal proposal = manager.find(Proposal.class, proposalId);
   manager.remove(proposal);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public Proposal findById(Long proposalId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(Proposal.class, proposalId);
  } finally {
   manager.close();
  }
 }

 public List<Proposal> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select proposal from Proposal proposal");
   @SuppressWarnings("unchecked")
   List<Proposal> items = query.getResultList();
   for (Proposal item : items) {
    item.getProposal().size();
   }
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}