package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class RoleDAOException extends DAOException {
    public RoleDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
