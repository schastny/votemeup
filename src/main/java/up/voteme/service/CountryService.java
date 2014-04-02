package up.voteme.service;

import java.util.List;

import up.voteme.domain.Country;

public interface CountryService {
	public abstract void store(Country country);

	public abstract void delete(Long id);

	public abstract Country findById(Long id);

	public abstract List<Country> findAll();

	public abstract long getCount();
}
