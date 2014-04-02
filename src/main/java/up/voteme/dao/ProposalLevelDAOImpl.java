package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.ProposalLevel;

@Component
public class ProposalLevelDAOImpl implements ProposalLevelDAO {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public long store(ProposalLevel item) {
		long id = manager.merge(item).getId();
		return id;
	}

	@Override
	public void delete(Long id) {
		ProposalLevel proposalLevel = manager.find(ProposalLevel.class,id);
		manager.remove(proposalLevel);
	}

	@Override
	public ProposalLevel findById(Long id) {
		return manager.find(ProposalLevel.class, id);
	}

	@Override
	public List<ProposalLevel> findAll() {
		 TypedQuery<ProposalLevel> query = manager.createQuery("SELECT pl FROM ProposalLevel pl", ProposalLevel.class);
		  List<ProposalLevel> proposalLevel = query.getResultList();
		  
		  return proposalLevel;
	}

}
