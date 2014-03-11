package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class DAOException extends Exception {
    public DAOException(String s, HibernateException e) {
        super(s, e);
    }
}
