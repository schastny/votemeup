/**
 * 
 */
package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import up.voteme.domain.City;
import up.voteme.domain.Country;
import up.voteme.domain.Region;

/**
 * @author marengo
 *
 */
public class TestRegionDAO {
	
	private	RegionDAO regionDao = new RegionDAO();
	private	CityDAO cityDao = new CityDAO();
	private	CountryDAO countryDao = new CountryDAO();
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link up.voteme.dao.RegionDAO#RegionDAO()}.
	 */
	@Test
	public void testRegionDAO() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link up.voteme.dao.RegionDAO#store(up.voteme.domain.Region)}.
	 */
	@Test
	public void testCreateNewRegion() {
		
		Country country = new Country();
		country = countryDao.findById((long) 1);
		
		City city = new City();
		city = cityDao.findById((long) 2);
		System.out.println("City = "+city.getCityName());
		
		 HashSet<City> hashSet = new HashSet<City>();
		 hashSet.add(city);
		
		 Region region = new Region();
		 region.setRegionName("GAGARIN");
		 region.setCountry(country);
		 
		 long id =  regionDao.store(region);		 
		 
		 assertNotNull(region);
		 assertNotNull(id);		
		
	}

	@Test
	public void testChangeCountryInRegion() {
		
		Region region = new Region();
		Country countryBefore = new Country();
		 
		region = regionDao.findById((long) 5);
		countryBefore = region.getCountry();
		
		
		Country countryNew = new Country();
		countryNew = countryDao.findById((long) 2);
		
		
		region.setCountry(countryNew);
		 
		long id =  regionDao.store(region);
		 
		region = regionDao.findById(id);
		countryNew = region.getCountry();  
		 
		assertEquals(countryBefore, countryNew);
	}
	
	
	/**
	 * Test method for {@link up.voteme.dao.RegionDAO#delete(java.lang.Long)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link up.voteme.dao.RegionDAO#findById(java.lang.Long)}.
	 */
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link up.voteme.dao.RegionDAO#findAll()}.
	 */
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
