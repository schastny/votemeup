package up.voteme.dao;

import java.util.List;

import up.voteme.domain.District;

public interface IDistrictDAO {

	public abstract long store(District item);
	public abstract void delete(Long Id);
	public abstract District findById(Long Id);
	public abstract List<District> findAll();

	public abstract List<District> getByCityId(long id);
}