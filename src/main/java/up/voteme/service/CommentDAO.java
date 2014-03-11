package up.voteme.service;

import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.exception.dao.CommentDAOException;

import java.sql.Date;
import java.util.List;

public interface CommentDAO {
    public void addComment(Comment comment) throws CommentDAOException;

    public void deleteComment(int id) throws CommentDAOException;

    public Comment getComment(int id) throws CommentDAOException;

    public List<Comment> getAllCommentsByUser(User user) throws CommentDAOException;

    public List<Comment> getAllCommentsByProposal(Proposal proposal) throws CommentDAOException;

    public List<Comment> getAllCommentsByDate(Date date) throws CommentDAOException;

    public void updateComment(Comment comment) throws CommentDAOException;
}
