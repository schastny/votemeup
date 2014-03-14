package up.voteme.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import up.voteme.domain.Comment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Sorts test methods in lexicographic order
public class CommentDAOTest {

	private	CommentDAO CommentTable = new CommentDAO();

	@Test
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
	public void Test_B_InsertNewRecord(){
		System.out.println("Trying to insert new record...");
		
		List<Comment> CommentBasicList = CommentTable.findAll();
		System.out.println("Table contains " + CommentBasicList.size() + " records.");
		
			Comment NewComment = CommentTable.findById(1L);
			NewComment.setCommentId(0);
			NewComment.setCommentText("Новый тестовый комментарий");
			CommentTable.store(NewComment);

		List<Comment> CommentChangedList = CommentTable.findAll();
		System.out.println("Now table contains " + CommentChangedList.size() + " records.");
		
		assertFalse("Record appending failure.", CommentBasicList.size() == CommentChangedList.size());
	}
	
	@Test
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
