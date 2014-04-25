package up.voteme.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import up.voteme.model.SimpleUser;

@Service
public class UserdServiceImpl implements UserdService {
	
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
	public List<SimpleUser> findAllSimple() {
		// TODO Auto-generated method stub
		List<Userd> uList= userdDAO.findAll();
		List<SimpleUser> sList = new ArrayList<>();
		for (Userd u : uList){
			sList.add(new SimpleUser(u));
		}
		return sList;
	}
	

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
