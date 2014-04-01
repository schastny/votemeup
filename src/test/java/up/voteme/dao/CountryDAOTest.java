package up.voteme.dao;

import static org.junit.Assert.assertFalse;

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

import up.voteme.domain.Country;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class) 

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Sorts test methods in lexicographic order

public class CountryDAOTest {
	@Autowired
	private	CountryDAO CountryTable;

	@Test
	@Transactional
	
	public void Test_A_SelectAll() {

		System.out.println("Trying to select all records from table...");

		List<Country> CountryList = CountryTable.findAll();	// Creating list from table Country

		for (int i = 0; i < CountryList.size(); i++) {
			System.out.println("Record " + i + ": " + CountryList.get(i));
			}

		System.out.println("Selecting " + CountryList.size() + " records.");
		assertFalse("No records found.", CountryList.size() == 0);
	}

	
	@Test
	@Transactional
	public void Test_B_InsertNewRecord(){
		List<Country> CountryBasicList = CountryTable.findAll();
		System.out.println("Table contains " + CountryBasicList.size() + " records.");
		
		System.out.println("Trying to insert new record...");
		
			Country NewCountry = new Country();
			NewCountry.setCountryName("Крым");
			CountryTable.store(NewCountry);
		
		List<Country> CountryChangedList = CountryTable.findAll();
		System.out.println("Now table contains " + CountryChangedList.size() + " records.");
		
		assertFalse("Record appending failure.", CountryBasicList.size() == CountryChangedList.size());
	}
	
	@Test
	@Transactional
	public void Test_C_DeleteLastRecord(){

		List<Country> CountryBasicList = CountryTable.findAll();
		System.out.println("Table contains " + CountryBasicList.size() + " records.");

		System.out.println("Trying to delete last record...");
		long LastRecordID = CountryBasicList.size();
		CountryTable.delete(LastRecordID);

		List<Country> CountryChangedList = CountryTable.findAll();
		System.out.println("Now table contains " + CountryChangedList.size() + " records.");
		
		assertFalse("Record deletion failure.", CountryBasicList.size() == CountryChangedList.size());
	}


}
