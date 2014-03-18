package up.voteme.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.UserDAO;
import up.voteme.domain.Userd;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void store(Userd user) {
		userDAO.store(user);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) {
		userDAO.deleteById(id);
	}
	
	@Transactional
	@Override
	public Userd showById(Long id) {
		return userDAO.findById(id);
	}
	
	@Transactional
	@Override
	public List<Userd> showAll() {
		return userDAO.findAll();
	}

}
