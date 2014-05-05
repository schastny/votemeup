package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Role;

public interface RoleDAO {

	public abstract long store(Role item);

	public abstract void delete(long RoleId);

	public abstract Role findById(long RoleId);

	public abstract List<Role> findAll();

	public abstract long countAll();

	public Role findByName (String name);

}