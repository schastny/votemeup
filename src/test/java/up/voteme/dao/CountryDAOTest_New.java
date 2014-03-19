package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.Country;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Sorts test methods in lexicographic order
public class CountryDAOTest_New {

	private	CountryDAO CountryTable = new CountryDAO();

	@Test
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
	public void Test_B_InsertNewRecord(){
		System.out.println("Trying to insert new record...");
		
		List<Country> CountryBasicList = CountryTable.findAll();
		System.out.println("Table contains " + CountryBasicList.size() + " records.");
		
			Country NewCountry = CountryTable.findById(1L);
			NewCountry.setCountryId(0);
			NewCountry.setCountryName("Крым");
			CountryTable.store(NewCountry);

		List<Country> CountryChangedList = CountryTable.findAll();
		System.out.println("Now table contains " + CountryChangedList.size() + " records.");
		
		assertFalse("Record appending failure.", CountryBasicList.size() == CountryChangedList.size());
	}
	
	@Test
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
