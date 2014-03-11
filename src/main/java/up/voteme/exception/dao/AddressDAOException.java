package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class AddressDAOException extends DAOException {
    public AddressDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
