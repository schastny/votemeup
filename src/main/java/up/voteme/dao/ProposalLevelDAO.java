package up.voteme.dao;

import java.util.List;

import up.voteme.domain.ProposalLevel;

public interface ProposalLevelDAO {

	public abstract long store(ProposalLevel item);

	public abstract void delete(Long Id);

	public abstract ProposalLevel findById(Long Id);

	public abstract List<ProposalLevel> findAll();

}