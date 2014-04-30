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
	public Userd findByLogin(String login){
		return userdDAO.findByLogin(login);
	}
	
	@Override
	@Transactional
	public Userd findByEmail(String email){
		return userdDAO.findByEmail(email);
	}
	

	@Transactional
	@Override
	public void store(Userd user) {
		userdDAO.store(user);
	}

	@Transactional
	@Override
	public void delete(long id) {
		userdDAO.delete(id);
	}
}
