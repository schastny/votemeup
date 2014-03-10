package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Role;
import up.voteme.exception.dao.RoleDAOException;
import up.voteme.service.RoleDAO;

import static up.voteme.util.HibernateUtil.*;

public class RoleHibernateDAO implements RoleDAO
{
    @Override
    public void addRole(Role role) throws RoleDAOException
    {
        try
        {
            begin();
            getSession().save(role);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new RoleDAOException("Could't add role!" + role, e);
        }
    }

    @Override
    public void deleteRole(Role role) throws RoleDAOException
    {
        try
        {
            begin();
            getSession().delete(role);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new RoleDAOException("Could't delete role!" + role, e);
        }
    }

    @Override
    public Role getRole(int id) throws RoleDAOException
    {
        Role role;
        try
        {
            begin();
            role = (Role)getSession().get(Role.class, id);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new RoleDAOException("Could't get role by ID!" + id, e);
        }
        return role;
    }

    //todo doesn't work :(
    @Override
    public void updateRole(Role role) throws RoleDAOException
    {
        try
        {
            begin();
            getSession().update(role);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new RoleDAOException("Could't update role! " + role, e);
        }
    }
}
