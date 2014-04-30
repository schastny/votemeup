package up.voteme.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.UserStatusDAO;
import up.voteme.domain.UserStatus;

@Service
public class UserStatusServiceImpl implements UserStatusService {
	@Autowired
    private UserStatusDAO userStatusDAO;
  

	/* (non-Javadoc)
	 * @see up.voteme.service.UserStatusService#findById(long)
	 */
	@Override
	@Transactional
	public UserStatus findById(long id) {
        return userStatusDAO.findById(id);
    }
	
	@Override
	@Transactional
	public List<UserStatus> findAll() {
        return userStatusDAO.findAll();
    }
}
