package up.voteme.service;

import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.domain.Vote;
import up.voteme.exception.dao.VoteDAOException;

import java.util.Date;
import java.util.List;

public interface VoteDAO {

    public void addVote(Vote vote) throws VoteDAOException;

    public List<Vote> getAllVotesByUser(User user) throws VoteDAOException;

    public List<Vote> getAllVotesByProposal(Proposal proposal) throws VoteDAOException;

    public List<Vote> getAllVotesByDate(Date date) throws VoteDAOException;

}
