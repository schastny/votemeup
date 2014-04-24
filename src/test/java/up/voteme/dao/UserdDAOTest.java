package up.voteme.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Country;
import up.voteme.domain.Role;
import up.voteme.domain.UserStatus;
import up.voteme.domain.Userd;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class UserdDAOTest {
	@Autowired
	private	UserdDAO dao;


	
	@Test
	@Transactional
	public void A_findAllTest() {
		System.out.println("Find all items...");
        int count =(int) (Math.random()*1000);
		
		Userd item = new Userd();
		
		Country country = new Country();
		country.setCountryId(1);
		
		Role role = new Role();
		role.setRoleId(1);
		
		UserStatus userStatus = new UserStatus();
		userStatus.setId(1);
	
		item.setFirstName("Иванов");
		item.setLastName("Иван");
		item.setBirthYear(25);
		item.setSex("male");
		item.setUserLogin("userlogin"+count);
		item.setEmail("bla"+count+"@mail.ru");
		item.setUserStatus(userStatus);
		item.setRole(role);
		item.setCountry(country);			
	     dao.store(item);
		
		List<Userd> list = dao.findAll();

		assertTrue ("No records in table",list.size()>0);
	}

	
	@Test
	@Transactional
	public void B_storeTest(){
		System.out.println("Store new item....");
		List<Userd> beforList = dao.findAll();
        
	    int count =(int) (Math.random()*1000);
		
		Userd item = new Userd();
		
		Country country = new Country();
		country.setCountryId(1);
		
		Role role = new Role();
		role.setRoleId(1);
		
		UserStatus userStatus = new UserStatus();
		userStatus.setId(1);
	
		item.setFirstName("Иванов");
		item.setLastName("Иван");
		item.setBirthYear(25);
		item.setSex("male");
		item.setUserLogin("userlogin"+count);
		item.setEmail("bla"+count+"@mail.ru");
		item.setUserStatus(userStatus);
		item.setRole(role);
		item.setCountry(country);			
	    long id = dao.store(item);
		List<Userd> afterList = dao.findAll();
		System.out.println("New item stored with id=" + id);
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		
		assertTrue ("Error in DB record store ",beforList.size() == afterList.size()-1);
	}
	
	@Test
	@Transactional
	public void C_findByIdTest() {
		System.out.println("Find last record ....");
		long id = dao.findAll().size();
		Userd item = dao.findById(id);
		System.out.println("Item id="+id+" was found, getClass="+item.getClass());
	}
	
	
	@Test
	@Transactional
	public void D_deleteTest() {
		System.out.println("Delete last record(assume ID = num of rec)....");
		List<Userd> beforList = dao.findAll();
		long id = beforList.size();        // = befor size
		dao.delete(id);
		List<Userd> afterList = dao.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record delete ",beforList.size() == afterList.size()+1);
	}

}
