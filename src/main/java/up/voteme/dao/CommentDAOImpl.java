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
		long Id = eMgr.merge(item).getCommentId();
		return Id;
	}

	@Override
	public void delete(long CommentId) {              // delete record
		Comment Comment = eMgr.find(Comment.class, CommentId);
		eMgr.remove(Comment);
	}

	@Override
	public Comment findById(long CommentId) {         // find record
		return eMgr.find(Comment.class, CommentId);
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
		// TODO Auto-generated method stub
		return null;
	}
}