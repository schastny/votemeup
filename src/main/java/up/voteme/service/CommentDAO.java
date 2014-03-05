package up.voteme.service;

import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;

import java.sql.Date;
import java.util.List;

public interface CommentDAO
{
    public void addComment(Comment comment);

    public void deleteComment(int id);

    public Comment getComment(int id);

    public List<Comment> getAllCommentsByUser(User user);

    public List<Comment> getAllCommentsByProposal(Proposal proposal);

    public List<Comment> getAllCommentsByDate(Date date);

    public void updateComment(int id);
}
