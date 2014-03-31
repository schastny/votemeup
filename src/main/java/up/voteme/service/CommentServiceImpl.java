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
private CommentDAO CommentDAO;

	@Transactional
	@Override
	public void store(Comment Comment) {
		CommentDAO.store(Comment);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		CommentDAO.delete(id);
	}
	
	@Transactional
	@Override
	public Comment findById(Long id) {		
		return  CommentDAO.findById(id);
	}

	@Transactional
	@Override
	public List<Comment> findAll() {		
		return  CommentDAO.findAll();
	}

	@Override
	@Transactional
	public long getCount() {
		return CommentDAO.countAll();
	}

}
