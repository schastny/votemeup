package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Comment;

public interface CommentDAO {

	public abstract long store(Comment item);

	public abstract void delete(long CommentID);

	public abstract Comment findById(long CommentID);

	public abstract List<Comment> findAll();

	public abstract long countAll();

	public abstract List<Comment> findCommentByProposal(long id);
	
}