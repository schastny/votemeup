package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Country;

public interface CountryDAO {

	public abstract long store(Country item);

	public abstract void delete(long countryId);

	public abstract Country findById(long countryId);

	public abstract List<Country> findAll();

	public abstract long countAll();

	public Country findByName (String name);

}