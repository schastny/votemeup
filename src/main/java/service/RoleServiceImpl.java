package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.RoleDAO;
import up.voteme.domain.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional
	@Override
	public void store(Role role) {
		roleDAO.store(role);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) {
		roleDAO.deleteById(id);
		
	}
	
	@Transactional
	@Override
	public Role showById(Long id) {
		return roleDAO.findById(id);
		
	}
	
	@Transactional
	@Override
	public List<Role> showAll() {
		return roleDAO.findAll();
	}
	
}
