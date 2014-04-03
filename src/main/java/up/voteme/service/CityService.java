package up.voteme.service;

import java.util.List;

import up.voteme.domain.City;

public interface CityService {

	public abstract List<City> getAll();
	public abstract void delete(long id);

	public abstract List<City> getByRegionId(long id);

}