package up.voteme.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.ProposalStatus;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
public class TestProposalStatusDAO {

	@Autowired
	private	ProposalStatusDAO psDao;
	

	@Test
	@Transactional 
	public void testProposalStatusDAO() {
		fail("Not yet implemented");
	}


	@Test
	@Transactional 
	public void testCreateNewProposalStatus() {
		
		ProposalStatus proposalStatus = new ProposalStatus();
		proposalStatus.setStatus("NEW STATUS CREATE");
		long id =  psDao.store(proposalStatus);		 
		 
		assertNotNull(proposalStatus);
		assertNotNull(id);		
		 
		 //psDao.delete(id);
		 	
	}

	

	@Test
	@Transactional 
	public void testRenameProposalStatus() {
		
		//create new ProposalStatus

		ProposalStatus proposalStatus = new ProposalStatus();
		proposalStatus.setStatus("NEW STATUS RENAME");
		long id =  psDao.store(proposalStatus);		 
		
		//change name in proposalStatus
		proposalStatus = psDao.findById(id);
		String newName = "RENAME NEW STATUS";
		proposalStatus.setStatus(newName);
		
		id =  psDao.store(proposalStatus);
		 
		proposalStatus = psDao.findById(id);

		
		assertEquals(newName, proposalStatus.getStatus());
		
		//psDao.delete(id);
	}
	
	
	@Test
	@Transactional 
	public void testDeleteProposalStatus() {
		//create new ProposalStatus
		ProposalStatus proposalStatus = new ProposalStatus();
		proposalStatus.setStatus("NEW STATUS DELETE");
		long id =  psDao.store(proposalStatus);		 
		
		//delete new ProposalStatus
		psDao.delete(id);
		
		//find ProposalStatus by id
		proposalStatus = psDao.findById(id);
		
		assertNull(proposalStatus);

	}

	@Test
	@Transactional 
	public void testFindById() {

		//create new ProposalStatus
		ProposalStatus proposalStatus = new ProposalStatus();
		proposalStatus.setStatus("NEW STATUS FIND");
		long id =  psDao.store(proposalStatus);		 
		
		//find proposalStatus by id
		proposalStatus = psDao.findById(id);

		
		assertEquals("NEW STATUS FIND", proposalStatus.getStatus());
	
	}

	@Test
	@Transactional 
	public void testFindByIdNotExsist() {
		//create new ProposalStatus
		ProposalStatus proposalStatus = new ProposalStatus();
		proposalStatus.setStatus("NEW STATUS FIND");
		long id =  psDao.store(proposalStatus);		 
		
		//delete new ProposalStatus
		psDao.delete(id);
		
		//find ProposalStatus by id
		proposalStatus = psDao.findById(id);
		
		assertNull(proposalStatus);
	}
	
	
	@Test
	@Transactional 
	public void testFindAll() {
		System.out.println("Find all items...");
		List<ProposalStatus> list = psDao.findAll();
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("etc......");
		System.out.println("total "+list.size()+" items");

		
		assertTrue ("No records in table",list.size()>1);		
	
	
	}

	@Test
	@Transactional 
	public void testCountPS() {
		System.out.println("Find count all items...");
		long count = psDao.countAll();
		System.out.println("total "+count+" items");
		
		assertTrue ("No records in table",count>1);		
	
	
	}
	
	
}
