package up.voteme.dao;



import java.util.List;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import up.voteme.domain.Proposal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //set junit  to 4.11
public class ProposalDAOTest {

	private	ProposalDAO dao = new ProposalDAO();
	private static final Logger logger = LoggerFactory.getLogger("");

	@Test
	public void A_findAllTest() {
		final int SHOW_ITEMS = 5;
		logger.info("Find all items, show first "+ SHOW_ITEMS+" items....");
		List<Proposal> list = dao.findAll();
		for (int i = 0; i<= SHOW_ITEMS; i++){
			logger.info(list.get(i).toString());
			if ((i == SHOW_ITEMS-1)&(list.size()>SHOW_ITEMS)) {
				logger.info("etc...... total "+list.size()+" items");
				break;
			}
		}
		assertTrue ("No records in table",list.size()>1);
		
		logger.info("Store item (size()-1) ....");
		Proposal prop = list.get(list.size()-1);
		prop.setProposalId(0);
		long id =  dao.store(prop);
		logger.info("New item stored with id="+id);
		
		
		
		
		
		
		
		
	}

	
	@Test
	public void B_storeTest(){
		logger.info("Store new item....");
		List<Proposal> beforList = dao.findAll();
		Proposal item = new Proposal();
		long id =  dao.store(item);
		List<Proposal> afterList = dao.findAll();
		logger.info("New item stored with id="+id);
		logger.info("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record store ",beforList.size() == afterList.size()-1);
	}
	
	@Test
	public void C_findByIdTest() {
		logger.info("Find last record (assume ID = num of rec)....");
		long id = dao.findAll().size();
		Proposal item = dao.findById(id);
		logger.info("Item id="+id+" was found, getClass="+item.getClass());
	}
	
	@Test
	public void D_deleteTest() {
		logger.info("Delete last record(assume ID = num of rec)....");
		List<Proposal> beforList = dao.findAll();
		long id = beforList.size();        // = befor size
		dao.delete(id);
		List<Proposal> afterList = dao.findAll();
		logger.info("Item id="+id+" was deleted");
		logger.info("Befor size = "+beforList.size()+", after size = "+afterList.size());
		assertTrue ("Error in DB record delete ",beforList.size() == afterList.size()+1);
	}
	
	
	
}
