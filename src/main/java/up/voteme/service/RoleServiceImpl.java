package up.voteme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.RoleDAO;
import up.voteme.domain.Role;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;

	/* (non-Javadoc)
	 * @see up.voteme.service.RoleService#findAll()
	 */
	@Override
	@Transactional
	public List<Role> findAll() {
		List<Role> list = roleDAO.findAll();
		for (Role r :list){
			r.setRoleDescr(null);
			r.setUsers(null);
		}
        return list;
	}
        
	/* (non-Javadoc)
	 * @see up.voteme.service.RoleService#findAllString()
	 */
	@Override
	@Transactional
	public List<String> findAllString() {
		List<Role> list =  roleDAO.findAll();
		List<String> result = new ArrayList<>();
		for (Role r :list){
			result.add(r.getRoleName());
		}
		return result;
	}

}