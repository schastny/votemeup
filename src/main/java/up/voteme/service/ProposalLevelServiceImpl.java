package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.ProposalLevelDAO;
import up.voteme.domain.ProposalLevel;

@Service
public class ProposalLevelServiceImpl implements ProposalLevelService {

	@Autowired
	private ProposalLevelDAO plDAO;
	
	@Override
	@Transactional
	public void store(ProposalLevel item) {
		plDAO.store(item);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		plDAO.delete(id);
	}

	@Override
	@Transactional
	public ProposalLevel findById(Long id) {
		return plDAO.findById(id);
	}

	@Override
	@Transactional
	public List<ProposalLevel> findAll() {
		return plDAO.findAll();
	}

}
