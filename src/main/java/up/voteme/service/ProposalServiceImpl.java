package up.voteme.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.HomeController;
import up.voteme.dao.ProposalDAO;
import up.voteme.dao.VoteDAO;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProposalServiceImpl.class);
    @Autowired
    private ProposalDAO dao;
  
    

    /* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#getAll()
	 */
    @Override
	@Transactional
	public List<Proposal> getAll() {
        return dao.findAll();
       
    }
    

	/* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#delete(long)
	 */
	@Override
	@Transactional
    public void delete(long id) {
    	dao.delete(id);
    }
	
	/* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#count()
	 */
	@Override
	@Transactional
    public long countAll() {
		//System.out.println("Service - countAll()");
    	return dao.countAll();
    }
	
	
	@Override
	@Transactional
	public Proposal getById(long id) {
		Proposal proposal = dao.findById(id);
		proposal.getCategories().size();
		proposal.getComments().size();
		proposal.getVotes().size();
		proposal.getDocuments().size();
		
		return proposal;
	}




	@Override
	@Transactional
	public RequestResult findByParams(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return dao.findByParams(map);
	}




	
}
