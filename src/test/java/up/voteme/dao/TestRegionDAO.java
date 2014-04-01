/**
 * 
 */
package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Country;
import up.voteme.domain.Region;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class TestRegionDAO {
	
	@Autowired
	private	RegionDAO regionDao;
	
	@Autowired
	private	CountryDAO countryDao;


	@Test
	@Transactional 
	public void testRegionDAO() {
		fail("Not yet implemented");
	}

	@Test
	@Transactional 
	public void testCreateNewRegion() {
		
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		
		//City city = new City();
		//city = cityDao.findById((long) 2);
		//System.out.println("City = "+city.getCityName());
		
		//HashSet<City> hashSet = new HashSet<City>();
		//hashSet.add(city);
		
		 Region region = new Region();
		 region.setRegionName("GAGARIN_140313_1");
		 region.setCountry(country);
		 
		 long id =  regionDao.store(region);		 
		 
		 assertNotNull(region);
		 assertNotNull(id);		
		 
		 //regionDao.delete(id);
		 	
	}

	@Test
	@Transactional 
	public void testChangeCountryInRegion() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_2");
		region.setCountry(country);
		long id =  regionDao.store(region);		 

		//change country in region
		Country countryNew = new Country();
		countryNew = countryDao.findById((long) 2);
		region = regionDao.findById(id);
		region.setCountry(countryNew);
		id =  regionDao.store(region);
		 
		
		assertEquals("Country not match...",countryNew, region.getCountry());
		
		//regionDao.delete(id);
	}
	

	@Test
	@Transactional 
	public void testRenameRegion() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_2");
		region.setCountry(country);
		long id =  regionDao.store(region);		 
		
		//change name in region
		region = regionDao.findById(id);
		String newName = "TITOV";
		region.setRegionName(newName);
		
		id =  regionDao.store(region);
		 
		region = regionDao.findById(id);

		
		assertEquals(newName, region.getRegionName());
		
		//regionDao.delete(id);
	}
	
	
	@Test
	@Transactional 
	public void testDelete() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_3");
		region.setCountry(country);
		long id =  regionDao.store(region);
		
		//delete new region
		regionDao.delete(id);
		
		//find region by id
		region = regionDao.findById(id);
		
		assertNull(region);
		
	}

	@Test
	@Transactional 
	public void testFindById() {
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_3");
		region.setCountry(country);
		long id =  regionDao.store(region);		 
		
		//find region by id
		region = regionDao.findById(id);

		
		assertEquals("GAGARIN_140313_3", region.getRegionName());
	}

	@Test
	@Transactional 
	public void testFindByIdNotExsist() {
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
System.out.println("country = "+country);		
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_3");
		region.setCountry(country);
		long id =  regionDao.store(region);
		
		//delete new region
		regionDao.delete(id);
		
		//find region by id
		region = regionDao.findById(id);
		
		assertNull(region);
	}
	
	
	@Test
	@Transactional 
	public void testFindAll() {
		//FindAll - 
		System.out.println("Find all items...");
		List<Region> list = regionDao.findAll();
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("etc......");
		System.out.println("total "+list.size()+" items");

		
		assertTrue ("No records in table",list.size()>1);		
	}

}
