package up.voteme.exception.dao;

import org.hibernate.HibernateException;

/**
 * Created with IntelliJ IDEA.
 * User: st1ch
 * Date: 3/9/14
 * Time: 5:14 PM
 * Package name: up.voteme.exception.dao
 * Project name: votemeup
 */
public class CategoryDAOException extends DAOException
{
    public CategoryDAOException(String s, HibernateException e)
    {
        super(s,e);
    }
}
