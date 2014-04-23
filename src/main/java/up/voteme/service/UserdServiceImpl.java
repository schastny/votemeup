package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import up.voteme.dao.UserdDAO;
import up.voteme.domain.Userd;

@Service
public class UserdServiceImpl implements UserdService {
	
	@Autowired
    private UserdDAO userdDAO;

    @Override
	@Transactional
	public List<Userd> findAll() {
        return userdDAO.findAll();
    }
    
    @Override
	@Transactional
	public Userd findById(long id) {
        return userdDAO.findById(id);
    }
    
    @Override
	@Transactional
	public void delete(long id) {
        userdDAO.delete(id);
    }
    
    @Override
	@Transactional
	public void store(Userd u) {
        userdDAO.store(u);
    }
}
