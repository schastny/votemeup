package up.voteme.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Proposal;

public interface ProposalService {

	public abstract List<Proposal> getAll();

	public abstract void delete(long id);

	public abstract long countAll();

}