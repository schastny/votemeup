package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.ProposalStatusDAO;
import up.voteme.domain.ProposalStatus;

@Service
public class ProposalStatusServiceImpl implements ProposalStatusService {
	
	@Autowired
	private ProposalStatusDAO psDAO;

    @Override
	@Transactional
    public long store(ProposalStatus item) {
    	return psDAO.store(item);
    }

    @Override
	@Transactional
    public void delete(long id) {
    	psDAO.delete(id);
    }
	
    @Override
    @Transactional
	public List<ProposalStatus> getAllPS() {
        return psDAO.findAll();
    }

	@Override
    @Transactional
	public ProposalStatus getById(long id) {
		return psDAO.findById(id);
	}

	@Override
    @Transactional
	public long getCount() {
		return psDAO.countAll();
	}
    
	
	
}
