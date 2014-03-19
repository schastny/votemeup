package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Userd;

public interface UserDAO {

	public void store(Userd user);
	
	public void deleteById(Long id);
	
	public Userd findById(Long id);
	
	public List<Userd> findAll();
	
}