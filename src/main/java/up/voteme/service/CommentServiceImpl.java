package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.CommentDAO;
import up.voteme.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	

	@Transactional
	@Override
	public void store(Comment comment) {
		commentDAO.store(comment);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		commentDAO.delete(id);
	}
	
	@Transactional
	@Override
	public Comment findById(Long id) {		
		return  commentDAO.findById(id);
	}

	@Transactional
	@Override
	public List<Comment> findAll() {		
		return  commentDAO.findAll();
	}

	@Override
	@Transactional
	public long getCount() {
		return commentDAO.countAll();
	}

	@Override
	@Transactional
	public List<Comment> getCommentByProposal(long id) {
		return commentDAO.findCommentByProposal(id);
	}

	@Override
	@Transactional
	public long getCountComment(long id) {
		return commentDAO.countCommentByProposal(id);
	}

	
	
}
