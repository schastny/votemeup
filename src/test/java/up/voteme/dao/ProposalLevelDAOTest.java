package up.voteme.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import up.voteme.domain.ProposalLevel;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// set junit to 4.11
public class ProposalLevelDAOTest {

	@Autowired
	private ProposalLevelDAO dao;
	private static final Logger logger = LoggerFactory
			.getLogger(ProposalLevelDAOTest.class);

	public long store(ProposalLevel item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ProposalLevel findById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProposalLevel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long Id) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Test
	public void A_findAllTest() {
		final int SHOW_ITEMS = 5;
		System.out.println("Find all items....");
		List<ProposalLevel> list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			// comment if block to show all items
			if ((i == SHOW_ITEMS - 1) & (list.size() > SHOW_ITEMS)) {
				System.out.println("etc......");
				System.out.println("total " + list.size() + " items");
				break;
			}
		}
		assertTrue("No records in table", list.size() > 1);
	}

	@Transactional
	@Test
	public void B_storeTest() {
		System.out.println("Store new item....");
		List<ProposalLevel> beforList = dao.findAll();
		// modify item
		//ProposalLevel item = dao.findById(1L);
		
		ProposalLevel item = new ProposalLevel();
		
		//System.out.println(item); // debug
		
		//item.setId(1);
		item.setLevel("OHOHOHOHOHO");

		long id = dao.store(item);
		List<ProposalLevel> afterList = dao.findAll();
		System.out.println("New item stored with id=" + id);
		System.out.println("Befor size = " + beforList.size()
				+ ", after size = " + afterList.size());
		assertTrue("Error in DB record store ",
				beforList.size() == afterList.size()-1);
	}

	@Transactional
	@Test
	public void C_findByIdTest() {
		System.out.println("Find last record (assume ID = num of rec)....");
		long id = dao.findAll().size();
		ProposalLevel item = dao.findById(id);
		System.out.println("Item id=" + id + " was found, getClass="
				+ item.getClass());
	}

	@Transactional
	@Test
	public void D_deleteTest() {
		System.out.println("Delete last record(assume ID = num of rec)....");
		List<ProposalLevel> beforList = dao.findAll();
		long id = beforList.size(); // = befor size
		dao.delete(id);
		List<ProposalLevel> afterList = dao.findAll();
		System.out.println("Item id=" + id + " was deleted");
		System.out.println("Befor size = " + beforList.size()
				+ ", after size = " + afterList.size());
		assertTrue("Error in DB record delete ",
				beforList.size() == afterList.size() + 1);
	}

}
