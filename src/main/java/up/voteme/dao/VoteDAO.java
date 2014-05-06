package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Vote;

public interface VoteDAO {
	public abstract long store(Vote vote);
	public abstract void delete(long id);
	public abstract Vote findById(long id);

	public abstract List<Vote> findUserVotesForProp(long userId, long propId);

	public abstract List<Vote> findAll();
	public abstract long countAll();
	public abstract long countVoteByProposalYes(long id);
	public abstract long countVoteByProposalNo(long id);

}
