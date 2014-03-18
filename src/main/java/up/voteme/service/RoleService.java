package up.voteme.service;

import java.util.List;

import up.voteme.domain.Role;

public interface RoleService {

	public void store(Role role);
	
	public void deleteById(Long id);
	
	public Role showById(Long id);
	
	public List<Role> showAll();
	
}
