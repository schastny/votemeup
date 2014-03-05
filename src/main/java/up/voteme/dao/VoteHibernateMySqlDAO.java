package up.voteme.dao;

import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.domain.Vote;
import up.voteme.service.VoteDAO;

import java.util.Date;
import java.util.List;

public class VoteHibernateMySqlDAO implements VoteDAO
{
    @Override
    public void addVote(Vote vote)
    {

    }

    @Override
    public List<Vote> getAllVotesByUser(User user)
    {
        return null;
    }

    @Override
    public List<Vote> getAllVotesByProposal(Proposal proposal)
    {
        return null;
    }

    @Override
    public List<Vote> getAllVotesByDate(Date date)
    {
        return null;
    }
}
