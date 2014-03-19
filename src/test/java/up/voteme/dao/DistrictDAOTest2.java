package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.District;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DistrictDAOTest2 {
	private IDistrictDAO daoDistrict = new DistrictDAO();

	@Test
	public void A_findAllTest() {
		System.out.println("Starting test FIND ALL....");
		List<District> listItem = daoDistrict.findAll();
		for (int i = 0; i < listItem.size(); i++) {
			System.out.println("Item :" + listItem.get(i));
		}
		assertFalse("The table is empty!", listItem.size() == 0);
		// assertTrue("The table is empty!", listItem.size() == 0);
		System.out.println("Finish test FIND ALL....");
	}

	@Test
	public void B_findByIdTest() {
		System.out.println("Find first record in table....");
		long id = daoDistrict.findAll().size()
				- (daoDistrict.findAll().size() - 1);
		District item = daoDistrict.findById(id);
		System.out.println("First item = " + id + " item disctict:"
				+ item.getDistrictName());
		System.out.println("Finish test FIND BY ID....");

	}
	
	@Test
	public void C_storeTest(){
		System.out.println("Starting STORE test....");
		List<District> beforList = daoDistrict.findAll();
		long listSizeBefore = beforList.size();
		District item = daoDistrict.findById(1L);
	    item.setDistrictId(0);
		item.setDistrictName("Universitetska22");
		long id =  daoDistrict.store(item);
		List<District> afterList = daoDistrict.findAll();
		long listSizeAfter = afterList.size();
		System.out.println("New item stored with id="+id);
		System.out.println("Finish STORE test....");
		assertTrue ("Error  writing! ",listSizeBefore == listSizeAfter-1);
	}

	@Test
	public void D_deleteTest() {
		System.out.println("Starting DELETE last item test....");
		List<District> beforList = daoDistrict.findAll();
		long id = beforList.size();      
		daoDistrict.delete(id);
		List<District> afterList = daoDistrict.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		System.out.println("Finish DELETE test....");
		assertFalse ("Error deleting ",beforList.size() == afterList.size());
	
	}

}
