package up.voteme.service;

import java.util.List;

import up.voteme.domain.UserStatus;

public interface UserStatusService {

	public abstract UserStatus findById(long id);
	
	public abstract List<UserStatus> findAll();

}