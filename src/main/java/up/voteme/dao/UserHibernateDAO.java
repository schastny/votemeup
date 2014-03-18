package up.voteme.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.User;
import up.voteme.exception.dao.UserDAOException;
import up.voteme.service.UserDAO;
import up.voteme.util.HibernateUtil;

import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addUser(User user) throws UserDAOException {
        try {
            begin();
            getSession().save(user);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't add user! " + user, e);
        }
    }

    @Override
    public void deleteUser(User user) throws UserDAOException {
        try {
            begin();
            getSession().delete(user);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't delete user! " + user, e);
        }
    }

    @Override
    public User getUserById(int id) throws UserDAOException {
        User user;
        try {
            begin();
            user = (User) getSession().get(User.class, id);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't get user by ID!" + id, e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws UserDAOException {
        List<User> users = null;

        try {
            begin();
            //users = getSession().createCriteria(User.class).list();
            users = (List<User>) getSession().createQuery("from User").list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't get all users!", e);
        }

        return users;
    }

    @Override
    public User getUserByLogin(String login) throws UserDAOException {
        User user = null;
        try {
            begin();
            user = (User) getSession().createQuery("from User where login =:login")
                    .setString("login", login);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't get user by login!" + login, e);
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws UserDAOException {
        try {
            begin();
            getSession().update(user);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new UserDAOException("Could't update user! " + user, e);
        }
    }
}
