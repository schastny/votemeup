package up.voteme.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Proposal;

public interface ProposalService {

	public abstract List<Proposal> getAll();

	public abstract void delete(long id);

	public abstract List<Proposal> getAllbyDate();

	public abstract List<Proposal> getAllbyVoteNum();

	// service methods for guesthomepage

	public abstract long countAll();

	public abstract List<Proposal> getByParams(HashMap<String, String> map);

	/*
	 * !!! ( 1.noSort = showAll; 2. use .equalseIgnoreCase(); 3.hint: int num =
	 * Integer.parseInt(..) ) map structure(key = value), expected parameters in
	 * curly braces : 
	 * sortBy = {noSort, voteCount, creationDate, commentCount};
	 * pageNum = {1..countAll() / PageQuant};
	 * pageQuant = {10,25,50};
	 * filtrByLevel = {noSort, Collection: proposalLevel.findAll().getLevel};
	 * filtrByStatus = {noSort, Collection: proposalStatus.findAll().getStatus};
	 * filtrByCategory = {noSort, Collection:
	 * proposalCategory.findAll().getCategoryName()}; filtrByCountry = {noSort,
	 * Collection: country.findAll().getCountryName}; filtrByRegion = {noSort,
	 * Collection: region.findAll().get..}; filtrByCity = {noSort, Collection:
	 * city.findAll().get..}; filtrByDistrict = {noSort, Collection:
	 * district.findAll().get..};
	 */
	
	/*
	 * Also we need: public abstract List<Region> getByCountryName (String
	 * countryName); public abstract List<City> getByRegionName (String
	 * regionName); public abstract List<District> getByCityName (String
	 * cityName);
	 */

}