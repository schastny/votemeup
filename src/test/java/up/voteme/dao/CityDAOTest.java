package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import up.voteme.domain.City;



@FixMethodOrder(MethodSorters.NAME_ASCENDING) //set junit  to 4.11
public class CityDAOTest {

	private	CityDAO dao = new CityDAO();

	@Test
	public void A_findAllTest() {
		final int SHOW_ITEMS = 5;
		System.out.println("Find all items....");
		List<City> list = dao.findAll();
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
			// comment if block to show all items
			if ((i == SHOW_ITEMS-1)&(list.size()>SHOW_ITEMS)) {
				System.out.println("etc......");
				System.out.println("total "+list.size()+" items");
				break;
			}
		}
		assertTrue ("No records in table",list.size()>1);
	}

	
	@Test
	public void B_storeTest(){
		System.out.println("Store new item....");
		List<City> beforList = dao.findAll();
		//create new item by modifying of existent
		City item = dao.findById(1L);
		item.setCityId(0);
		item.setCityName("OHOHOHOHOHO");
		long id =  dao.store(item);
		//more correct create in DAO layer query with COUNT 
		List<City> afterList = dao.findAll();
		System.out.println("New item stored with id="+id);
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Record in DB not added  ",beforList.size() == afterList.size()-1);
	}
	
	@Test
	public void C_findByIdTest() {
		System.out.println("Find last record (assume ID = num of rec)....");
		long id = dao.findAll().size();
		City item = dao.findById(id);
		assertTrue ("Error in DB record retrieve ", item.getCityName().equals("OHOHOHOHOHO"));
		System.out.println("Item id="+id+" was found, Name="+item.getCityName());
	}
	
	@Test
	public void D_updateTest(){
		System.out.println("Update last record with new name 'BEBEBEBEBEBE'....");
		long id = dao.findAll().size();
		City item = dao.findById(id);
		//modify
		item.setCityName("BEBEBEBEBEBE");
		id =  dao.store(item);
		
		item = dao.findById(id);
		assertTrue ("Error in DB record update ", item.getCityName().equals("BEBEBEBEBEBE"));
		System.out.println("Item id="+id+" was found, Name="+item.getCityName());
	}
	
	@Test
	public void E_deleteTest() {
		System.out.println("Delete last record(assume ID = num of rec)....");
		List<City> beforList = dao.findAll();
		long id = beforList.size();        // = befor size
		dao.delete(id);
		List<City> afterList = dao.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record delete ",beforList.size() == afterList.size()+1);
	}
	
	
	
}