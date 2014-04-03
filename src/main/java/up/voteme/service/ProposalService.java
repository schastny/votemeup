package up.voteme.service;

import java.util.HashMap;
import java.util.List;

import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;

public interface ProposalService {

	public abstract List<Proposal> getAll();

	public abstract void delete(long id);

	// service methods for guesthomepage

	public abstract long countAll();
	//Ponomarenko
	public abstract Proposal getById(long id);
	
	
	public abstract RequestResult findByParams(HashMap<String, String> map);

	/*
	 * !!! ( 0 = noSort = showAll); 
	 * map structure(key = value), expected parameters in
	 * curly braces : 
	 * 
	 * sortBy = {noSort, voteCount, creationDate, commentCount};
	 * pageNum = {1..countAll() / PageQuant};
	 * pageQuant = {1..100};
	 * filtrByLevelId = {0, Collection: proposalLevel.findAll().getLevelId};
	 * filtrByStatusId = {0, Collection: proposalStatus.findAll().getStatusId};
	 * filtrByCategoryId = {0, Collection:proposalCategory.findAll().getCategoryId}; 
	 * filtrByCountryId = {0,Collection: country.findAll().getCountryId}; 
	 * filtrByRegionId = {0, Collection: region.findAll().get..}; 
	 * filtrByCityId = {0, Collection:city.findAll().get..}; 
	 * filtrByDistrictId = {0, Collection:district.findAll().get..};
	 */
	
	

}