package up.voteme.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.CountryDAO;
import up.voteme.dao.RoleDAO;
import up.voteme.dao.UserStatusDAO;
import up.voteme.dao.UserdDAO;
import up.voteme.domain.Country;
import up.voteme.domain.Role;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;
import up.voteme.model.PaginatedUser;
import up.voteme.model.SimpleUser;
import up.voteme.web.CountryController;

@Service
public class UserdServiceImpl implements UserdService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserdServiceImpl.class);
	
	@Autowired
    private UserdDAO userdDAO;
	@Autowired
    private CountryDAO countryDAO;
	@Autowired
    private UserStatusDAO userStatusDAO;
	@Autowired
    private RoleDAO roleDAO;
	

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

    @Override
	@Transactional
	public long countAll() {
        return userdDAO.countAll();
    }
    
    

	@Override
	@Transactional
	public PaginatedUser findPaginated(int pageNumber, int perPage) {
		// TODO 
		//List<SimpleUser> uList= userdDAO.findPaginatedSimpleUser(int pageNumber, int perPage);
		
		List<Userd> userds = userdDAO.findAll();
        List<SimpleUser> sUsers = new ArrayList<>();
        for (Userd u :userds){
        	sUsers.add(new SimpleUser(u));
        }
        List<SimpleUser> result = new ArrayList<>();
        int upperLimit = pageNumber*perPage > sUsers.size() ? sUsers.size():pageNumber*perPage;
        for (int i = (pageNumber-1)*perPage; i < upperLimit; i++){
        	result.add(sUsers.get(i));
        }
        PaginatedUser u = new PaginatedUser();
        u.setUsers(result);
        u.setTotalRecords(sUsers.size());
        return u;
	}
	
	

	
	
	@Override
	@Transactional
	public boolean validate (SimpleUser sUser) {
		
		int length = sUser.getFirstName().length();
		if ( length < 2 || length > 50) {
			return false;
		}
		
		length = sUser.getLastName().length();
		if (length < 2 || length > 50){
			return false;
			
		}
		
		length = sUser.getEmail().length();
		if (length < 2 || length > 255){
			return false;
			
		}
		
		length = sUser.getUserLogin().length();
		if (length < 2 || length > 255){
			return false;
			
		}
		
		length = sUser.getUserPassword().length();
		if (length != 40){
			return false;
			
		}
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date()); // your date
	    int curYear = cal.get(Calendar.YEAR);
	    int age = curYear - sUser.getBirthYear();
	    if (age < 14 || age > 120 ){
	    	return false;
	    	
	    }
		
	    String sex = sUser.getSex();
	    if (!sex.equals("муж")&&!sex.equals("жен")){
	    	return false;
	    	
	    }
	    
	    // Check if login is unique
	    Userd u = userdDAO.findByLogin(sUser.getUserLogin());
	    if (u != null) {
	    	if (u.getUserdId() != sUser.getUserdId()){
	    		return false;
	    		
	    	}
	    }
	    
	    // Check if email is unique
	    u = userdDAO.findByEmail(sUser.getUserLogin());
	    if (u != null) {
	    	if (u.getUserdId() != sUser.getUserdId()){
	    		return false;
	    		
	    	}
	    }
	    
	    // Check if Country correct
	    Country c = countryDAO.findByName(sUser.getCountry());
	    if (c == null) {
	    	return false;
	    }
	    
	    // Check if Role correct
	    Role r = roleDAO.findByName(sUser.getRole());
	    if (r == null) {
    		return false;
	    }
	    
	    // Check if UserStatus correct
	    UserStatus  s = userStatusDAO.findByName(sUser.getUserStatus());
	    if (s == null) {
    		return false;
	    }
	    
		return true;
	}
	
	@Override
	@Transactional
	public void updateUserdAndStore (SimpleUser sUser) {

			Userd user = userdDAO.findById(sUser.getUserdId());
			user.setFirstName(sUser.getFirstName());
			user.setLastName(sUser.getLastName());
			user.setBirthYear(sUser.getBirthYear());
			user.setSex(sUser.getSex());
			user.setEmail(sUser.getEmail());
			user.setUserLogin(sUser.getUserLogin());
			user.setUserPassword(sUser.getUserPassword());
			Role role = roleDAO.findByName(sUser.getRole());
			user.setRole(role);
			UserStatus  status = userStatusDAO.findByName(sUser.getUserStatus());
			user.setUserStatus(status);
			Country country = countryDAO.findByName(sUser.getCountry());
			user.setCountry(country);
			userdDAO.store(user);

	}
}
