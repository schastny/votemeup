package up.voteme.dao;

import java.util.HashMap;
import java.util.List;

import up.voteme.domain.Proposal;

public interface ProposalDAO {

	public abstract long store(Proposal item);

	public abstract void delete(long id);

	public abstract Proposal findById(long categoryId);

	public abstract List<Proposal> findAll();

	public abstract long countAll();
	
	public List<Proposal> findAllbyDate();
	
	public List<Proposal> findByParams(HashMap<String,String> map);

}