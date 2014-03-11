package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.exception.dao.CommentDAOException;
import up.voteme.service.CommentDAO;

import java.sql.Date;
import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class CommentHibernateDAO implements CommentDAO {
    @Override
    public void addComment(Comment comment) throws CommentDAOException {
        try {
            begin();
            getSession().save(comment);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't add comment!" + comment, e);
        }
    }

    @Override
    public void deleteComment(int id) throws CommentDAOException {
        try {
            begin();
            getSession().createQuery("delete from Comment where comment_id =:id")
                    .setInteger("id", id)
                    .executeUpdate();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't delete comment by ID!" + id, e);
        }
    }

    @Override
    public Comment getComment(int id) throws CommentDAOException {
        Comment comment;
        try {
            begin();
            comment = (Comment) getSession().get(Comment.class, id);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't get comment by ID!" + id, e);
        }
        return comment;
    }

    @Override
    public List<Comment> getAllCommentsByUser(User user) throws CommentDAOException {
        List<Comment> comments;
        try {
            begin();
            int userId = user.getId();
            comments = (List<Comment>) getSession().createQuery("from Comment where comment_id =:userId")
                    .setInteger("userId", userId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't get all comments by user!" + user, e);
        }
        return comments;
    }

    @Override
    public List<Comment> getAllCommentsByProposal(Proposal proposal) throws CommentDAOException {
        List<Comment> comments;
        try {
            begin();
            int proposalId = proposal.getId();
            comments = (List<Comment>) getSession().createQuery("from Comment where proposal_id =:proposalId")
                    .setInteger("proposalId", proposalId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't get all comments by proposal!" + proposal, e);
        }
        return comments;
    }

    @Override
    public List<Comment> getAllCommentsByDate(Date date) throws CommentDAOException {
        List<Comment> comments;
        try {
            begin();
            comments = (List<Comment>) getSession().createQuery("from Comment where publication_date =:date")
                    .setDate("date", date)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new CommentDAOException("Could't get all comments by date!" + date, e);
        }
        return comments;
    }

    @Override
    public void updateComment(int id) {

    }
}
