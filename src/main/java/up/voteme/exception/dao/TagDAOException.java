package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class TagDAOException extends DAOException {
    public TagDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
