package up.voteme.service;

import java.util.List;

import up.voteme.domain.District;

public interface DistrictService {
	public abstract void store(District district);

	public abstract void delete(Long id);

	public abstract District findById(Long id);

	public abstract List<District> findAll();

	public abstract List<District> getByCityId(long id);
}
