package up.voteme.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import up.voteme.domain.User;
import up.voteme.exception.dao.UserDAOException;
import up.voteme.service.UserDAO;
import up.voteme.util.HibernateUtil;

import java.util.List;

import static up.voteme.util.HibernateUtil.*;
import static up.voteme.util.HibernateUtil.rollback;

public class UserHibernateDAO implements UserDAO
{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addUser(User user) throws UserDAOException
    {
        try
        {
            begin();
            getSession().save(user);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new UserDAOException("Could't add user! " + user, e);
        }
    }

    @Override
    public void deleteUser(User user) throws UserDAOException
    {
        try
        {
            begin();
            getSession().delete(user);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new UserDAOException("Could't delete user! " + user, e);
        }
    }

    @Override
    public User getUserById(int id)
    {
        User user = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User)session.get(User.class, id);
        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> users = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        session.close();

        return users;
    }

    @Override
    public User getUserByLogin(String login)
    {
        User user = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        user = (User)criteria.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public void updateUser(int id)
    {

    }
}
