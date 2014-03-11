package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class VoteDAOException extends DAOException {
    public VoteDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
