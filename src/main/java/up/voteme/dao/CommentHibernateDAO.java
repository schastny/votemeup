package up.voteme.dao;

import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.service.CommentDAO;

import java.sql.Date;
import java.util.List;

public class CommentHibernateDAO implements CommentDAO
{
    @Override
    public void addComment(Comment comment)
    {

    }

    @Override
    public void deleteComment(int id)
    {

    }

    @Override
    public Comment getComment(int id)
    {
        return null;
    }

    @Override
    public List<Comment> getAllCommentsByUser(User user)
    {
        return null;
    }

    @Override
    public List<Comment> getAllCommentsByProposal(Proposal proposal)
    {
        return null;
    }

    @Override
    public List<Comment> getAllCommentsByDate(Date date)
    {
        return null;
    }

    @Override
    public void updateComment(int id)
    {

    }
}
