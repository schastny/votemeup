package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import up.voteme.domain.VoteProposal;

public class VoteProposalDAO {
 private EntityManagerFactory entityManagerFactory;

 public VoteProposalDAO() {
  entityManagerFactory = Persistence.createEntityManagerFactory("votemeup_new");
 }
 
 public void store(VoteProposal voteProposal) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   manager.merge(voteProposal);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public void delete(Long voteProposalId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  EntityTransaction tx = manager.getTransaction();
  try {
   tx.begin();
   VoteProposal voteProposal = manager.find(VoteProposal.class, voteProposalId);
   manager.remove(voteProposal);
   tx.commit();
  } catch (RuntimeException e) {
   tx.rollback();
   throw e;
  } finally {
   manager.close();
  }
 }

 public VoteProposal findById(Long voteProposalId) {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   return manager.find(VoteProposal.class, voteProposalId);
  } finally {
   manager.close();
  }
 }

 public List<VoteProposal> findAll() {
  EntityManager manager = entityManagerFactory.createEntityManager();
  try {
   Query query = manager.createQuery("select voteProposal from VoteProposal voteProposal");
   @SuppressWarnings("unchecked")
   List<VoteProposal> items = query.getResultList();
   for (VoteProposal item : items) {
    item.getVoteProposal().size();
   }
   
   return items;

  } finally {
   manager.close();
  }
 }
 
}