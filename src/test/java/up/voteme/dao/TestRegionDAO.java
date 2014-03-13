/**
 * 
 */
package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import up.voteme.domain.Country;
import up.voteme.domain.Region;

public class TestRegionDAO {
	
	private	RegionDAO regionDao = new RegionDAO();
	private	CountryDAO countryDao = new CountryDAO();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegionDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateNewRegion() {
		
		Country country = new Country();
		country = countryDao.findById((long) 1);
		
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
	public void testChangeCountryInRegion() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
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
	public void testRenameRegion() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
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
	public void testDelete() {
		
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
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
	public void testFindById() {
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
		Region region = new Region();
		region.setRegionName("GAGARIN_140313_3");
		region.setCountry(country);
		long id =  regionDao.store(region);		 
		
		//find region by id
		region = regionDao.findById(id);

		
		assertEquals("GAGARIN_140313_3", region.getRegionName());
	}

	@Test
	public void testFindByIdNotExsist() {
		//create new region
		Country country = new Country();
		country = countryDao.findById((long) 1);
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
