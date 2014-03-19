package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.Document;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocumentDAOTest2 {
	private IDocumentDAO daoDocument = new DocumentDAOImpl();

	@Test
	public void A_findAllTest() {
		System.out.println("Starting test FIND ALL....");
		List<Document> listItem = daoDocument.findAll();
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
		long id = daoDocument.findAll().size()
				- (daoDocument.findAll().size() - 1);
		Document item = daoDocument.findById(id);
		System.out.println("First item = " + id + " item disctict:"
				+ item.getDocName());
		System.out.println("Finish test FIND BY ID....");

	}
	
	@Test
	public void D_storeTest(){ 
		System.out.println("Starting STORE test....");
		List<Document> beforList = daoDocument.findAll();
		long listSizeBefore = beforList.size();
		Document item = daoDocument.findById(1L);
	    item.setDocId(0);
		item.setDocName("cool document");
		item.setDocUrl("http:/google.com/img.png");
		long id =  daoDocument.store(item);
		List<Document> afterList = daoDocument.findAll();
		long listSizeAfter = afterList.size();
		System.out.println("New item stored with id="+id);
		System.out.println("Finish STORE test....");
		assertTrue ("Error  writing! ",listSizeBefore == listSizeAfter-1);
	}

	@Test
	public void C_deleteTest() {
		System.out.println("Starting DELETE last item test....");
		List<Document> beforList = daoDocument.findAll();
		long id = beforList.size() ;      
		daoDocument.delete(id);
		List<Document> afterList = daoDocument.findAll();
		System.out.println("Item id="+id+" was deleted");
		System.out.println("Befor size = "+beforList.size()+", after size = "+afterList.size());
		System.out.println("Finish DELETE test....");
		assertTrue ("Error deleting ",beforList.size() == afterList.size()+1);
	
	}

}
