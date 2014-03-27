package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Region;

public interface RegionDAO {
	public abstract long store(Region region);
	public abstract void delete(long id);
	public abstract Region findById(long id);
	public abstract List<Region> findAll();
	public abstract long countAll();

}
