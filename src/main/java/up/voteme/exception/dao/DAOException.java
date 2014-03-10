package up.voteme.exception.dao;

import org.hibernate.HibernateException;

/**
 * Created with IntelliJ IDEA.
 * User: st1ch
 * Date: 3/9/14
 * Time: 5:12 PM
 * Package name: up.voteme.exception.dao
 * Project name: votemeup
 */
public class DAOException extends Exception
{
    public DAOException(String s, HibernateException e)
    {
        super(s,e);
    }
}
