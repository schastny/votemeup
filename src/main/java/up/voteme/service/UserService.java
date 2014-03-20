package up.voteme.service;

import java.util.List;

import up.voteme.domain.Userd;

public interface UserService {
	
	public void store(Userd user);
	
	public void deleteById(Long id);
	
	public Userd showById(Long id);
	
	public List<Userd> showAll();
	
	public void addRandomUsers();

}
