package up.voteme.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import up.voteme.dao.UserdDAO;
import up.voteme.domain.Userd;



@Service
public class UserManager {
	private HashMap<String, Userd> users;
	private static final Logger logger = LoggerFactory
			.getLogger(UserManager.class);

	public UserManager() {
		users = new HashMap<String, Userd>();
		UserdDAO dao = new UserdDAO();
		List<Userd> list = dao.findAll();
		for (Userd u :list){
			users.put(u.getUserLogin(), u);
			logger.info("UserName(Login):"+u.getUserLogin()+", password: "+u.getPassword()
					+", autorities:"+u.getAuthorities());
		}
		//users.put("john", new User("john", "1", "ROLE_USER"));
		//users.put("bob", new User("bob", "2", "ROLE_USER, ROLE_ADMIN"));
	}
	
	public Userd getUser(String username) throws UsernameNotFoundException{
		if( !users.containsKey( username ) ){
			throw new UsernameNotFoundException( username + " not found" );
		}
		
		return users.get( username );		
	}
}
