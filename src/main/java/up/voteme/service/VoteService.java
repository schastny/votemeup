package up.voteme.service;

import java.util.List;

import up.voteme.domain.Vote;

public interface VoteService {
	public abstract long store(Vote vote);
	public abstract void delete(long id) ;

	public abstract List<Vote> findUserVotesForProp(long userId, long propId);

	public abstract List<Vote> getAllVote();
	public abstract Vote getById(long id);
	public abstract long getCount();
	public abstract long getCountVoteByProposalYes(long id);
	public abstract long getCountVoteByProposalNo(long id);

}
