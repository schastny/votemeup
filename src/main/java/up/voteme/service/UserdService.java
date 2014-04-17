package up.voteme.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Userd;

public interface UserdService {

	public abstract List<Userd> findAll();
	
	public abstract Userd findById(long id);

}