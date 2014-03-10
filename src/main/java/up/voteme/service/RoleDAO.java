package up.voteme.service;

import up.voteme.domain.Role;
import up.voteme.exception.dao.RoleDAOException;

public interface RoleDAO
{
    public void addRole(Role role) throws RoleDAOException;

    public void deleteRole(Role role) throws RoleDAOException;

    public Role getRole(int id) throws RoleDAOException;

    public void updateRole(Role role) throws RoleDAOException;
}
