package up.voteme.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Proposal;
import up.voteme.domain.ProposalLevel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class) 
public class ProposalDAOTest2 {
	@Autowired
	private ProposalDAO daoProposal;

	@Test
	@Transactional
	public void A_findAllTest() {
		System.out.println("Starting test FIND ALL....");
		List<Proposal> listItem = daoProposal.findAll();
		for (int i = 0; i < listItem.size(); i++) {
			System.out.println("Item :" + listItem.get(i));
		}
		assertFalse("The table is empty!", listItem.size() == 0);
		// assertTrue("The table is empty!", listItem.size() == 0);
		System.out.println("Finish test FIND ALL....");
	}

	@Test
	@Transactional
	public void B_findByIdTest() {
		System.out.println("Find first record in table....");
		long id = daoProposal.findAll().size();
		Proposal item = daoProposal.findById(id);
		System.out.println("First item = " + id + " item propsal:"+ item.getProposalName());
		System.out.println("Finish test FIND BY ID....");

	}

/*
	@Test
	@Transactional
	public void C_storeTest(){ 
		System.out.println("Starting STORE test....");
		List<Proposal> beforList = daoProposal.findAll();
		long listSizeBefore = beforList.size();
	
		Proposal item = new Proposal();
		
		//Document item = daoDocument.findById(1L);
	    //item.setDocId(0);
		//item.setDocName("cool document2222");
		//item.setDocUrl("http:/google.com/img.png");
		//item.setProposal(daoProposal.findById(1L).getProposal());
		//item.setProposal(daoDocument.findById(1L).getProposal());
		
		//ProposalLevel itemPL = new ProposalLevel();
		
		List<ProposalLevel> beforList = daoProposal.findAll();
		ProposalLevel itemPL = daoProposal.findById(1L)
		item.setProposalLevel(itemPL);
		
		long id =  daoProposal.store(item);
		List<Proposal> afterList = daoProposal.findAll();
		long listSizeAfter = afterList.size();
		System.out.println("New item stored with id="+id);
		System.out.println("Finish STORE test....");
		assertTrue ("Error  writing! ",listSizeBefore == listSizeAfter-1);
	}
*/
	
//	@Test
//	@Transactional
//	public void D_deleteTest() {
//		System.out.println("Starting DELETE last item test....");
//		List<Proposal> beforList = daoProposal.findAll();
//		long id = beforList.size();      
//		System.out.println("Item id="+id);
//		daoProposal.delete(id);
//		List<Proposal> afterList = daoProposal.findAll();
//		System.out.println("Item id="+id+" was deleted");
//		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
//		System.out.println("Finish DELETE test....");
//		assertTrue ("Error deleting ",beforList.size() == afterList.size()+1);	
//	}
}