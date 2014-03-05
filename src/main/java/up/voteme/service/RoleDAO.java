package up.voteme.service;

import up.voteme.domain.Role;

public interface RoleDAO
{
    public void addRole(Role role);
    public void deleteRole(Role role);
    public Role getRole(int id);
    public void updateRole(int id);
}
