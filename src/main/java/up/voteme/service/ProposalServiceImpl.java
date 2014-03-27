package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.ProposalDAO;
import up.voteme.domain.Proposal;

@Service
public class ProposalServiceImpl implements ProposalService {
	
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
		System.out.println("Service - countAll()");
    	return dao.countAll();
    }
	    
}
