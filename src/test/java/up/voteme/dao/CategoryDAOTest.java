package up.voteme.dao;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import up.voteme.domain.Category;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class CategoryDAOTest  {
	
	@Autowired
	private	CategoryDAO categoryDAO ;
	private static final Logger logger = LoggerFactory
			.getLogger(CategoryDAOTest.class);
	
	@Test 
	@Transactional 
		public void crudTest(){
		Category item; 
		long id; 
		long initSize;
		final String NAME = "HOHOHOHOHOHO";
		final String NEW_NAME = "BEBEBEBEBEBE";
		
		initSize = findAllItems();
		assertTrue ("No records in table",initSize > 1);
		item = createNewCategory(NAME);
		id = store(item);  //auto increment of ID used, so new ID = size + 1
		assertTrue ("Record in DB not added  ", id == initSize + 1);
		item = findById(id);
		assertTrue ("Error in DB record store/retrieve ", item.getCategName().equals(NAME));
		item.setCategName(NEW_NAME); //modify
		id = update(item); 
		item = findById(id);
		assertTrue ("Error in record update  ", id == initSize + 1);
		assertTrue ("Error in DB record update ", item.getCategName().equals(NEW_NAME));
		delete(id);
		long afterSize = countAllItems();
		assertTrue ("Error in record delete  ",initSize == afterSize);
	}
		
	public Category createNewCategory(String name){
		//create new item by modifying of existent
		Category item = new Category(name);
		return item;
	}
	
	
	public long findAllItems() {
		final int SHOW_ITEMS = 5;
		logger.info("Find all items....");
		List<Category> list = categoryDAO.findAll();
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
	
	public long  store(Category item){
		logger.info("Store new item....");
		long id =  categoryDAO.store(item);
		logger.info("New item stored with id="+id);
		return id;
	}
	
	public Category findById(long id) {
		logger.info("Find record...");
		Category item = categoryDAO.findById(id);
		logger.info("Item id="+id+" was found, name="+item.getCategName());
		return item;
	}
	
	public long update(Category item){
		logger.info("Update record ....");
		//modify
		long id = categoryDAO.store(item);
		logger.info("Item id="+id+" was updated");
		return id;
	}
	
	public void delete(long id) {
		logger.info("Delete last record....");
		categoryDAO.delete(id);
		logger.info("Item id="+id+" was deleted");
	}
	
	public long countAllItems() {
		logger.info("Count records in DB table....");
		long size =  categoryDAO.countAll();
		logger.info("Size="+size+" records");
		return size;
	}
	
	
	
	
}