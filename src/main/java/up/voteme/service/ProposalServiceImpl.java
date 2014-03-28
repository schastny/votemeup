package up.voteme.service;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
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
	
	@Transactional
	public List<Proposal> getAllbyDate() {
        return dao.findAllbyDate();
    }
	
	@Transactional
	public List<Proposal> getAllbyVoteNum() {
		List<Proposal> list = dao.findAll();
		 Collections.sort(list, new Comparator<Proposal>() {
		        public int compare(Proposal o1, Proposal o2) {
			        int x1 = o1.getVotes().size();
			        int x2 = o2.getVotes().size();
	                return x1 - x2;
		        }
		 });
		 Collections.reverse(list);
        return list;
    }
	
 
}
