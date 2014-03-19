package up.voteme.dao;

import java.util.List;

import up.voteme.domain.District;

public interface IDistrictDAO {

	public  long store(District item);

	public  void delete(Long Id);

	public  District findById(Long Id);

	public  List<District> findAll();

}