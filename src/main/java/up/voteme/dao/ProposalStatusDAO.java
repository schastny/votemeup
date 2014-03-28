package up.voteme.dao;

import java.util.List;

import up.voteme.domain.ProposalStatus;

public interface ProposalStatusDAO {
	public abstract long store(ProposalStatus proposalStatus);
	public abstract void delete(long id);
	public abstract ProposalStatus findById(long id);
	public abstract List<ProposalStatus> findAll();
	public abstract long countAll();
	

	
}
