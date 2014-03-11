package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class CategoryDAOException extends DAOException {
    public CategoryDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
