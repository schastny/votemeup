package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.VoteDAO;
import up.voteme.domain.Vote;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteDAO voteDAO;
	
	
	@Override
	@Transactional
	public long store(Vote vote) {
		return voteDAO.store(vote);
	}

	@Override
	@Transactional
	public void delete(long id) {
		voteDAO.delete(id);	

	}

	@Override
	@Transactional
	public List<Vote> getAllVote() {
		return voteDAO.findAll();
	}

	@Override
	@Transactional
	public Vote getById(long id) {
		return voteDAO.findById(id);
	}

	@Override
	@Transactional
	public long getCount() {
		return voteDAO.countAll();
	}

	@Override
	@Transactional
	public long getCountVoteByProposalYes(long id) {
		return voteDAO.countVoteByProposalYes(id);
	}

	@Override
	@Transactional
	public long getCountVoteByProposalNo(long id) {
		return voteDAO.countVoteByProposalNo(id);
	}
	
	
	
}
