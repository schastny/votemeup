package up.voteme.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public Userd findByLogin(String login){
		return userdDAO.findByLogin(login);
	}
	
	@Override
	@Transactional
	public Userd findByEmail(String email){
		return userdDAO.findByEmail(email);
	}
    

	@Override
	@Transactional
	public PaginatedUser findPaginated(int pageNumber, int perPage) {

		List<Userd> userdList= userdDAO.findPaginatedUserd(pageNumber, perPage);
		List<SimpleUser> suList = new ArrayList<>();
		for (Userd u : userdList){
			suList.add(new SimpleUser(u));
		}
		Long totalRecords = userdDAO.countAll();
		PaginatedUser user = new PaginatedUser();
        user.setUsers(suList);
        user.setTotalRecords(totalRecords);
		
		
		return user;
	}
	
	

	
	
	@Override
	@Transactional
	public boolean validate (SimpleUser sUser) {
		
		Pattern pattern = Pattern.compile("^([A-Za-zА-Яа-я]+[ -]*){2,50}$");
		Matcher matcher = pattern.matcher(sUser.getFirstName());
		if (!matcher.matches()){
			logger.debug("sUser.getFirstName() uncorrect" );
			return false;
		}
		
		matcher = pattern.matcher(sUser.getLastName());
		if (!matcher.matches()){
			logger.debug("sUser.getLastName() uncorrect" );
			return false;
		}
		
		int length = sUser.getEmail().length();
		if (length > 255){
			logger.debug("getEmail().length() > 255" );
			return false;
		}
		
		pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		matcher = pattern.matcher(sUser.getEmail());
		if (!matcher.matches()){
			logger.debug("sUser.getEmail() uncorrect" );
			return false;
		}

		pattern = Pattern.compile("^[0-9A-Za-z\\._-]{3,20}");
		matcher = pattern.matcher(sUser.getUserLogin());
		if (!matcher.matches()){
			logger.debug("sUser.getUserLogin() uncorrect" );
			return false;
		}
		
		pattern = Pattern.compile("^[0-9a-fA-F]{40}$");
		matcher = pattern.matcher(sUser.getUserPassword());
		if (!matcher.matches()){
			logger.debug("sUser.getUserPassword() uncorrect" );
			return false;
		}
		
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date()); 
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
