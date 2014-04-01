package up.voteme.service;

import java.util.List;

import up.voteme.domain.ProposalLevel;

public interface ProposalLevelService {
	public void store(ProposalLevel proposalLevel);

	public void delete(Long id);

	public ProposalLevel findById(Long id);

	public List<ProposalLevel> findAll();
}