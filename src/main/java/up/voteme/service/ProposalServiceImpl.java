package up.voteme.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.HomeController;
import up.voteme.dao.ProposalDAO;
import up.voteme.dao.VoteDAO;
import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProposalServiceImpl.class);
    @Autowired
    private ProposalDAO dao;
  
    @Autowired
    private VoteDAO voteDao;
    
    

    /* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#getAll()
	 */
    @Override
	@Transactional
	public List<Proposal> getAll() {
        return dao.findAll();
       
    }
    

	/* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#delete(long)
	 */
	@Override
	@Transactional
    public void delete(long id) {
    	dao.delete(id);
    }
	
	/* (non-Javadoc)
	 * @see up.voteme.service.ProposalService#count()
	 */
	@Override
	@Transactional
    public long countAll() {
		//System.out.println("Service - countAll()");
    	return dao.countAll();
    }
	
	
	@Override
	@Transactional
	public Proposal getById(long id) {
		return dao.findById(id);
	}


	@Override
	@Transactional
	public long getCountVoteYes(long id) {
		return voteDao.countVoteByProposalYes(id);
	}


	@Override
	@Transactional
	public long getCountVoteNo(long id) {
		return voteDao.countVoteByProposalNo(id);
	}
	
	@Override
	@Transactional
	public List<Proposal> getByParams(HashMap<String,String> map) {	
		return dao.findByParams(map);
		
	}



	@Override
	@Transactional
	public RequestResult findByParams(HashMap<String, String> map) {
		//Mock implementation
		long count = dao.countAll();
		
		//Mock implementation
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
		List<Proposal> resultList = new ArrayList<>();
		if (map.containsKey("pageNum")&&map.containsKey("pageQuant")){
			List<Proposal> listAll = dao.findAll();
			long size = listAll.size();
			int pageNum = Integer.parseInt(map.get("pageNum"));
			int pageQuant = Integer.parseInt(map.get("pageQuant"));
			long first = (pageNum-1)*pageQuant;
			long last = first+pageQuant;
			if (last > size){ // last page not full
				last = size;
			}
			for (long i=first; i<last; i++){
				resultList.add(listAll.get((int)i));
			}
			
		}
		return new RequestResult(count, resultList);
	}
	
}
