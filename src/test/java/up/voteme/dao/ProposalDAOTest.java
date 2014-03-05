package up.voteme.dao;



import java.util.List;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;
import up.voteme.domain.Proposal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //set junit  to 4.11
public class ProposalDAOTest {
	

	private	ProposalDAO dao = new ProposalDAO();

	

	@Test
	public void A_findAllTest() {
		final int SHOW_ITEMS = 5;
		System.out.println("Find all items, show first "+ SHOW_ITEMS+" items....");

		List<Proposal> list = dao.findAll();
		
		for (int i = 0; i<= SHOW_ITEMS; i++){
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
		List<Proposal> beforList = dao.findAll();
		Proposal item = new Proposal();
		long id =  dao.store(item);
		List<Proposal> afterList = dao.findAll();
		System.out.println("New item stored with id="+id);
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record store ",beforList.size() == afterList.size()-1);
	}
	
	@Test
	public void C_findByIdTest() {
		System.out.println("Find last record (assume ID = num of rec)....");
		long id = dao.findAll().size();
		Proposal item = dao.findById(id);
		System.out.println("Item id="+id+" was found, getClass="+item.getClass());
	}
	
	@Test
	public void D_deleteTest() {
		System.out.println("Delete last record(assume ID = num of rec)....");
		List<Proposal> beforList = dao.findAll();
		long id = beforList.size();        // = befor size
		dao.delete(id);
		List<Proposal> afterList = dao.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record delete ",beforList.size() == afterList.size()+1);
	}
	
	
	
}
