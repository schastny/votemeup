package up.voteme.dao;

import java.util.List;

import up.voteme.domain.UserStatus;

public interface UserStatusDAO {

	public abstract long store(UserStatus item);

	public abstract void delete(long UserStatusId);

	public abstract UserStatus findById(long UserStatusId);

	public abstract List<UserStatus> findAll();

	public abstract long countAll();
	
	public UserStatus findByName (String name);

}