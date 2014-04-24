package up.voteme.service;

import up.voteme.domain.UserStatus;

public interface UserStatusService {

	public abstract UserStatus findById(long id);

}