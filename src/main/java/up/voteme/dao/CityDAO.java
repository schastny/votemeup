package up.voteme.dao;

import java.util.List;

import up.voteme.domain.City;

public interface CityDAO {

	public abstract long store(City item);
	public abstract void delete(long cityId);
	public abstract City findById(long cityId);
	public abstract List<City> findAll();
	public abstract long countAll();

	public abstract List<City> getByRegionId(long id);
}