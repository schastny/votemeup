package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Comment;

@Component
public class CommentDAOImpl implements CommentDAO {
	
	@PersistenceContext
	EntityManager eMgr;
	
	@Override
	public long store(Comment item) {                 // store record
		long id = eMgr.merge(item).getCommentId();
		return id;
	}

	@Override
	public void delete(long commentId) {              // delete record
		Comment comment = eMgr.find(Comment.class, commentId);
		eMgr.remove(comment);
	}

	@Override
	public Comment findById(long commentId) {         // find record
		return eMgr.find(Comment.class, commentId);
	}

	@Override
	public List<Comment> findAll() {                  // select all records
		TypedQuery<Comment> query = eMgr.createQuery("SELECT com FROM Comment com", Comment.class);
		List<Comment> items = query.getResultList();
		for (Comment item : items) {
			System.out.println(item);
		}
		return items;
	}
	
	@Override
	public long countAll() {                          // return records count
		Query query = eMgr.createQuery("SELECT COUNT(*) FROM Comment");
		long result = (long) query.getSingleResult();
		return result;
	}

	@Override
	public List<Comment> findCommentByProposal(long id) {
		  TypedQuery<Comment> query =  eMgr.createQuery("SELECT com FROM Comment com WHERE proposal_id = " + id + " ORDER BY comment_date DESC", Comment.class);
			  List<Comment> items = query.getResultList();
			  for (Comment item : items) {
			   System.out.println(item);
			  }
			  return items;
	
	}

	@Override
	public long countCommentByProposal(long id) {

		Query query = eMgr.createQuery("SELECT COUNT(*) FROM Comment AS c WHERE c.proposal.id like "+id);
		long count = (long) query.getSingleResult();
		System.out.println("count comment for proposal("+id+") = " + count);
		return count;
	}
}