package up.voteme.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.UserDAO;
import up.voteme.domain.Userd;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void store(Userd user) {
		userDAO.store(user);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) {
		userDAO.deleteById(id);
	}
	
	@Transactional
	@Override
	public Userd showById(Long id) {
		return userDAO.findById(id);
	}
	
	@Transactional
	@Override
	public List<Userd> showAll() {
		return userDAO.findAll();
	}
	
	@Transactional
	@Override
	public void addRandomUsers() {
		Random rand = new Random();
        int howManyUsersWillBeAdded = rand.nextInt(9) + 1;
        for(int i = 0; i < howManyUsersWillBeAdded; i++) {
        	Userd user = new Userd();
        	user.setBirthYear(1980 + rand.nextInt(20));
        	user.setSex(rand.nextInt(2) == 0 ? "male" : "female");
        	user.setFirstName("MyName" + rand.nextInt(100));
        	user.setLastName("MyLastName" + rand.nextInt(100));
        	user.setEmail("MyE-mail" + rand.nextInt(100));
        	user.setRegistrationDate(new Date());
        	user.setLogin("MyLogin" + rand.nextInt(100));
        	user.setPassword("MyPassword" + rand.nextInt(100));
        	
        	userDAO.store(user);   
        }
	}

}
