package up.voteme.exception.dao;

import org.hibernate.HibernateException;

public class ProposalDAOException extends DAOException {
    public ProposalDAOException(String s, HibernateException e) {
        super(s, e);
    }
}
