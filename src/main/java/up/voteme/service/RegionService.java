package up.voteme.service;

import java.util.List;

import up.voteme.domain.Region;

public interface RegionService {
	public abstract long store(Region region);
	public abstract void delete(long id) ;

	
	public abstract List<Region> getAllRegion();
	public abstract Region getById(long id);
	public abstract long getCount();
	
	public abstract List<Region> getByCountryId(long id);
}
