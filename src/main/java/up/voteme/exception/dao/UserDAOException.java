package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class UserDAOException extends DAOException {
    public UserDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
