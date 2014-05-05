package up.voteme.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.District;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //set junit  to 4.11
public class DistrictDAOTest {

	private	IDistrictDAO dao = new DistrictDAOImpl();

	@Test
	public void A_findAllTest() {
		System.out.println("Find all items....");
		District dist = new District();
		dist.setDistrictId(1L);
		dist.setDistrictName("Sevastopolskiy");
		dao.store(dist);
		List<District> list = dao.findAll();
		assertTrue ("No records in table",list.size()>1);
	}

	
	@Test
	public void B_storeTest(){
		System.out.println("Store new item....");
		List<District> beforList = dao.findAll();
		//modify item
		District item = dao.findById(1L);
		item.setDistrictId(0);
		item.setDistrictName("OHOHOHOHOHO");
		
		long id =  dao.store(item);
		List<District> afterList = dao.findAll();
		System.out.println("New item stored with id="+id);
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record store ",beforList.size() == afterList.size()-1);
	}
	
	@Test
	public void C_findByIdTest() {
		System.out.println("Find last record (assume ID = num of rec)....");
		long id = dao.findAll().size();
		District item = dao.findById(id);
		System.out.println("Item id="+id+" was found, getClass="+item.getClass());
	}
	
	@Test
	public void D_deleteTest() {
		System.out.println("Delete last record(assume ID = num of rec)....");
		List<District> beforList = dao.findAll();
		long id = beforList.size();        // = befor size
		dao.delete(id);
		List<District> afterList = dao.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record delete ",beforList.size() == afterList.size()+1);
	}

	@Test
	public void E_FindByCityId() {
		System.out.println("Find all items...");
		List<District> list = dao.getByCityId((long) 522);
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("etc......");
		System.out.println("total "+list.size()+" items");

		
		assertTrue ("No records in table",list.size()>1);		
	}

}
