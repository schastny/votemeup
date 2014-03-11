package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class AttachmentDAOException extends DAOException {
    public AttachmentDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
