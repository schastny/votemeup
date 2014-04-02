package up.voteme.service;

import java.util.List;

import up.voteme.domain.Comment;

public interface CommentService {
	public abstract void store(Comment comment);

	public abstract void delete(Long id);

	public abstract Comment findById(Long id);

	public abstract List<Comment> findAll();

	public abstract long getCount();
	
	
	public abstract List<Comment> getCommentByProposal(long id);
	public abstract long getCountComment(long id);
	
}
