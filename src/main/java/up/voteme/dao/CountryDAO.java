package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Country;

public interface CountryDAO {

	public abstract long store(Country item);

	public abstract void delete(long CountryId);

	public abstract Country findById(long CountryId);

	public abstract List<Country> findAll();

	public abstract long countAll();

}