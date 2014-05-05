package up.voteme.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.City;
import up.voteme.domain.District;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class DistrictDAOTest2 {

	@Autowired
	private IDistrictDAO daoDistrict ;

	@Test
	@Transactional
	public void A_findAllTest() {
		List<District> listBefore = daoDistrict.findAll();
		System.out.println("Starting test FIND ALL....");
		District dist = new District();
		City city = new City();
		city.setCityId(1);
		dist.setDistrictId(1L);
		dist.setDistrictName("Sevastopolskiy");
		dist.setCity(city);
	    daoDistrict.store(dist);		
		List<District> listAfter = daoDistrict.findAll();
		System.out.println("Befor size = "+listBefore.size()+", after size = "+listAfter.size());
		assertFalse("The table is empty!", listAfter.size() == 0);
		// assertTrue("The table is empty!", listItem.size() == 0);
		System.out.println("Finish test FIND ALL....\n");
	}

	@Test
	@Transactional
	public void B_findByIdTest() {
		System.out.println("Find first record in table....");
		long id = daoDistrict.findAll().size()
				- (daoDistrict.findAll().size() - 1);
		District item = daoDistrict.findById(id);
		System.out.println("First item = " + id + " item disctict:"
				+ item.getDistrictName());
		System.out.println("Finish test FIND BY ID....\n");

	}
	
	@Test
	@Transactional
	public void C_storeTest(){
		System.out.println("Starting STORE test....");
		List<District> beforList = daoDistrict.findAll();
		long listSizeBefore = beforList.size();
		District item = new District();
		item.setDistrictName("Universitetska22");
		item.setCity(daoDistrict.findById(1L).getCity());
		
		long id =  daoDistrict.store(item);
		List<District> afterList = daoDistrict.findAll();
		long listSizeAfter = afterList.size();
		System.out.println("New item stored with id="+id);
		System.out.println("Finish STORE test....\n");
		assertTrue ("Error  writing! ",listSizeBefore == listSizeAfter-1);
	}

	@Test
	@Transactional
	public void D_deleteTest() {
		System.out.println("Starting DELETE last item test....");
		List<District> beforList = daoDistrict.findAll();
		long id = beforList.size();      
		daoDistrict.delete(id);
		List<District> afterList = daoDistrict.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		System.out.println("Finish DELETE test....\n");
		assertFalse ("Error deleting ",beforList.size() == afterList.size());
	
	}

	@Test
	@Transactional
	public void E_FindByCityId() {
		System.out.println("Find all items by CityID...");
		List<District> list = daoDistrict.getByCityId((long) 522);
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("etc......");
		System.out.println("total "+list.size()+" items");

		assertTrue ("No records in table",list.size()>1);		
	}

}
