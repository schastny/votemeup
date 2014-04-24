package up.voteme.service;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

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
	public UserStatus findById(long id) {
        return userStatusDAO.findById(id);
    }
}
