package up.voteme.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import up.voteme.dao.UserdDAO;
import up.voteme.domain.Userd;



@Service
public class UserManager {
	private HashMap<String, Userd> users;
	private static final Logger logger = LoggerFactory
			.getLogger(UserManager.class);
	
	@Autowired
	UserdDAO userdDao;
	
	public Userd getUser(String userLogin) throws UsernameNotFoundException{

		logger.debug("userLogin: "+userLogin);
		Userd user = userdDao.findByLogin(userLogin);
		if (user==null) {
			logger.warn("UsernameNotFoundException: "+userLogin + " not found");
			throw new UsernameNotFoundException(userLogin + " not found" );
		}
		return user;
	}
}
