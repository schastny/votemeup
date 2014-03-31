package up.voteme.service;

import java.util.List;

import up.voteme.domain.Comment;

public interface CommentService {
	public abstract void store(Comment Comment);

	public abstract void delete(Long id);

	public abstract Comment findById(Long id);

	public abstract List<Comment> findAll();

	public abstract long getCount();
}
