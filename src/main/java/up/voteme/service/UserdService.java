package up.voteme.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Userd;
import up.voteme.model.SimpleUser;

public interface UserdService {

	public abstract List<Userd> findAll();
	
	public abstract List<SimpleUser> findAllSimple();
	
	public abstract Userd findById(long id);
	
	public void delete(long id);
	
	public void store(Userd u);
	
	public void updateUserdAndStore (SimpleUser sUser);

}