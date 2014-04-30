package up.voteme.service;

import java.util.List;

import up.voteme.domain.Userd;

public interface UserdService {

	public abstract List<Userd> findAll();

	public abstract Userd findById(long id);

	public abstract void delete(long id);

	public abstract void store(Userd user);

	public abstract Userd findByLogin(String login);
	
	public abstract Userd findByEmail(String email);

}