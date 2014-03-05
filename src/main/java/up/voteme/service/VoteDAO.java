package up.voteme.service;

import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.domain.Vote;

import java.util.Date;
import java.util.List;

public interface VoteDAO
{
    public void addVote(Vote vote);
    public List<Vote> getAllVotesByUser(User user);
    public List<Vote> getAllVotesByProposal(Proposal proposal);
    public List<Vote> getAllVotesByDate(Date date);
}
