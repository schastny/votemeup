package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class CommentDAOException extends DAOException {
    public CommentDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
