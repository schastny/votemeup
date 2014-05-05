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

import up.voteme.domain.Document;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class) 
public class DocumentDAOTest2 {
	@Autowired
	private IDocumentDAO daoDocument;

	@Test
	@Transactional
	public void A_findAllTest() {
		System.out.println("Starting test FIND ALL....");
		List<Document> listItem2 = daoDocument.findAll();
		Document item = new Document();
	    item.setDocId(0);
		item.setDocName("cool document2222");
		item.setDocUrl("http:/google.com/img.png");
		item.setProposal(daoDocument.findById(1L).getProposal());	
		daoDocument.store(item);
		List<Document> listItem = daoDocument.findAll();
		System.out.println("Befor size = "+listItem2.size()+", after size = "+listItem.size());
		assertFalse("The table is empty!", listItem.size() == 0);
		// assertTrue("The table is empty!", listItem.size() == 0);
		System.out.println("Finish test FIND ALL....\n");
	}

	@Test
	@Transactional
	public void B_findByIdTest() {
		System.out.println("Find last record in table....");
		long id = daoDocument.findAll().size();
		Document item = daoDocument.findById(id);
		System.out.println("Last item = " + id + " item disctict:"+ item.getDocName());
		System.out.println("Finish test FIND BY ID....\n");

	}
	
	@Test
	@Transactional
	public void C_storeTest(){ 
		System.out.println("Starting STORE test....");
		List<Document> beforList = daoDocument.findAll();
		long listSizeBefore = beforList.size();
	
		Document item = new Document();
	    item.setDocId(0);
		item.setDocName("cool document2222");
		item.setDocUrl("http:/google.com/img.png");
		item.setProposal(daoDocument.findById(1L).getProposal());
		long id =  daoDocument.store(item);
		List<Document> afterList = daoDocument.findAll();
		long listSizeAfter = afterList.size();
		System.out.println("New item stored with id="+id);
		System.out.println("Finish STORE test....\n");
		assertTrue ("Error  writing! ",listSizeBefore == listSizeAfter-1);
	}

	@Test
	@Transactional
	public void D_deleteTest() {
		System.out.println("Starting DELETE last item test....");
		List<Document> beforList = daoDocument.findAll();
		long id = beforList.size() ;      
		daoDocument.delete(id);
		List<Document> afterList = daoDocument.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		System.out.println("Finish DELETE test....\n");
		assertTrue ("Error deleting ",beforList.size() == afterList.size()+1);
	
	}

}
