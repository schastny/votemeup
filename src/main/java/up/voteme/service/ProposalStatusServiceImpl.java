package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.voteme.dao.ProposalStatusDAO;
import up.voteme.domain.ProposalStatus;

@Service
public class ProposalStatusServiceImpl implements ProposalStatusService {
	
	@Autowired
	private ProposalStatusDAO psDAO;

	@Override
	public List<ProposalStatus> findAllPS() {
		return psDAO.getAllPS();
	}

}
