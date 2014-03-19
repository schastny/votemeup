package up.voteme.service;

import java.util.List;

import up.voteme.domain.District;

public interface DistrictService {
	public void store(District district);

	public void delete(Long id);

	public District findById(Long id);

	public List<District> findAll();

}
