package up.voteme.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.City;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class CityDAOTest {
	
	@Autowired
	private	CityDAO dao;
	private static final Logger logger = LoggerFactory
			.getLogger(CityDAOTest.class);

	@Test 
	@Transactional
	public void crudTest(){
		City item; 
		long id; 
		long initSize;
		final String NAME = "HOHOHOHOHOHO";
		final String NEW_NAME = "BEBEBEBEBEBE";
		
		initSize = findAllItems();
		assertTrue ("No records in table",initSize > 1);
		item = createNewCity(NAME);
		id = store(item);  //auto increment of ID used, so new ID = size + 1
		assertTrue ("Record in DB not added  ", id == initSize + 1);
		item = findById(id);
		assertTrue ("Error in DB record store/retrieve ", item.getCityName().equals(NAME));
		item.setCityName(NEW_NAME); //modify
		id = update(item); 
		item = findById(id);
		assertTrue ("Error in record update  ", id == initSize + 1);
		assertTrue ("Error in DB record update ", item.getCityName().equals(NEW_NAME));
		delete(id);
		long afterSize = countAllItems();
		assertTrue ("Error in record delete  ",initSize == afterSize);
	}
		
	public City createNewCity(String name){
		//create new item by modifying of existent
		City item = new City(name,findById(1L).getRegion());
		return item;
	}
	
	public long findAllItems() {
		final int SHOW_ITEMS = 5;
		logger.info("Find all items....");
		List<City> list = dao.findAll();
		for (int i = 0; i< list.size(); i++){
			logger.info(list.get(i).toString());
			// comment if block to show all items
			if ((i == SHOW_ITEMS-1)&(list.size()>SHOW_ITEMS)) {
				logger.info("etc... ");
				break;
			}
		}
		logger.info("Total collection size="+list.size()+" items");
		return list.size();
	}
	
	public long  store(City item){
		logger.info("Store new item....");
		long id =  dao.store(item);
		logger.info("New item stored with id="+id);
		return id;
	}
	
	public City findById(long id) {
		logger.info("Find record...");
		City item = dao.findById(id);
		logger.info("Item id="+id+" was found, name="+item.getCityName());
		return item;
	}
	
	public long update(City item){
		logger.info("Update record ....");
		//modify
		long id = dao.store(item);
		logger.info("Item id="+id+" was updated");
		return id;
	}
	
	public void delete(long id) {
		logger.info("Delete last record id="+id);
		dao.delete(id);
		logger.info("Item id="+id+" was deleted");
	}
	
	public long countAllItems() {
		logger.info("Count records in DB table....");
		long size =  dao.countAll();
		logger.info("Size="+size+" records");
		return size;
	}

	@Test
	@Transactional 
	public void testFindByRegionId() { 		//FindByRegionId
		System.out.println("Find all items by RegionID...");
		List<City> list = dao.getByRegionId((long) 1);
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("etc......");
		System.out.println("total "+list.size()+" items");

		
		assertTrue ("No records in table",list.size()>1);		
	}
	
}