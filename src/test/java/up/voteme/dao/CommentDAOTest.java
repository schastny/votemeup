package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.Comment;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class) 

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Sorts test methods in lexicographic order

public class CommentDAOTest {
	@Autowired
	private	CommentDAO CommentTable;

	@Test
	@Transactional
	public void Test_A_SelectAll() {

		System.out.println("Trying to select all records from table...");

		List<Comment> CommentList = CommentTable.findAll();	// Creating list from table Comment

		for (int i = 0; i < CommentList.size(); i++) {
			System.out.println("Record " + i + ": " + CommentList.get(i));
			}

		System.out.println("Selecting " + CommentList.size() + " records.");
		assertFalse("No records found.", CommentList.size() == 0);
	}

	
	@Test
	@Transactional
	public void Test_B_InsertNewRecord(){
		List<Comment> CommentBasicList = CommentTable.findAll();
		System.out.println("Table contains " + CommentBasicList.size() + " records.");
		
		System.out.println("Trying to insert new record...");
		
			Comment NewComment = new Comment();
			NewComment.setUserd(CommentTable.findById(1).getUserd());
			NewComment.setProposal(CommentTable.findById(1).getProposal());
			NewComment.setCommentDate(CommentTable.findById(1).getCommentDate());
			NewComment.setCommentText("Новый тестовый комментарий");
			CommentTable.store(NewComment);

		List<Comment> CommentChangedList = CommentTable.findAll();
		System.out.println("Now table contains " + CommentChangedList.size() + " records.");
		
		assertFalse("Record appending failure.", CommentBasicList.size() == CommentChangedList.size());
	}
	
	@Test
	@Transactional
	public void Test_C_DeleteLastRecord(){

		List<Comment> CommentBasicList = CommentTable.findAll();
		System.out.println("Table contains " + CommentBasicList.size() + " records.");

		System.out.println("Trying to delete last record...");
		long LastRecordID = CommentBasicList.size();
		CommentTable.delete(LastRecordID);

		List<Comment> CommentChangedList = CommentTable.findAll();
		System.out.println("Now table contains " + CommentChangedList.size() + " records.");
		
		assertFalse("Record deletion failure.", CommentBasicList.size() == CommentChangedList.size());
	}


}