package up.voteme.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;
import up.voteme.service.VoteService;
import up.voteme.web.GuestPageController;

@Component
public class ProposalDAOImpl implements ProposalDAO {
	

	@PersistenceContext
	private EntityManager em;
		
	@Autowired
	VoteDAO voteDAO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProposalDAOImpl.class);
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#store(up.voteme.domain.Proposal)
	 */
	@Override
	public long store(Proposal item) {
		long id= em.merge(item).getProposalId();	//store-update
		return id;
	}
	
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#delete(long)
	 */
	@Override
	public void delete(long id) {
		Proposal proposal = em.find(Proposal.class, id);
		em.remove(proposal);
	}
		
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#findById(long)
	 */
	@Override
	public Proposal findById(long categoryId) {
		 return em.find(Proposal.class, categoryId);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#findAll()
	 */
	@Override
	public List<Proposal> findAll() {
		TypedQuery<Proposal> query = em.createQuery(
		"SELECT p FROM Proposal p", Proposal.class);
		List<Proposal> items = query.getResultList();
		for (Proposal item : items) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return items;
	}
	
	public List<Proposal> findAllbyDate() {
		TypedQuery<Proposal> query = em.createQuery(
		"SELECT p FROM Proposal p ORDER BY creation_date", Proposal.class);
		List<Proposal> items = query.getResultList();
		for (Proposal item : items) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return items;
	}
	
	/* (non-Javadoc)
	 * @see up.voteme.dao.ProposalDAO#countAll()
	 */
	@Override
	public long countAll() {
		Query query = em.createQuery("select count(*) from Proposal");
		long result = (long) query.getSingleResult();
		return result;
	}
	
	
	public String queryBuilder  (HashMap<String,String> map){
		
		String resultString = "";
		Set<String> needSet = new HashSet<>();
		needSet.add("sortBy");
		needSet.add("pageNum");
		needSet.add("pageQuant");
		needSet.add("filtrByStatusId");
		needSet.add("filtrByLevelId");
		needSet.add("filtrByCategoryId");
		needSet.add("filtrByCountryId");
		needSet.add("filtrByRegionId");
		needSet.add("filtrByCityId");
		needSet.add("filtrByDistrictId");
		
		if (!map.keySet().containsAll(needSet)){
			throw new RuntimeException("Configuration map is uncorrect");
		}
		
		
		String fString = "";
		String wasFiltr = "";
		if (!map.get("filtrByStatusId").equals("0") ){
			fString +=(wasFiltr+"p.proposalStatus.id=" + map.get("filtrByStatusId"));
			wasFiltr = " AND ";
		}
		if (!map.get("filtrByLevelId").equals("0") ){
			fString +=(wasFiltr+"p.proposalLevel.id=" + map.get("filtrByLevelId"));
			wasFiltr = " AND ";
		}
		if (!map.get("filtrByCountryId").equals("0") ){
			fString +=(wasFiltr+"p.country.countryId=" + map.get("filtrByCountryId"));
			wasFiltr = " AND ";
		}
		if (!map.get("filtrByRegionId").equals("0") ){
			fString +=(wasFiltr+"p.region.regionId=" + map.get("filtrByRegionId"));
			wasFiltr = " AND ";
		}
		if (!map.get("filtrByCityId").equals("0") ){
			fString +=(wasFiltr+"p.city.cityId=" + map.get("filtrByCityId"));
			wasFiltr = " AND ";
		}
		if (!map.get("filtrByDistrictId").equals("0") ){
			fString +=(wasFiltr+"p.district.districtId=" + map.get("filtrByDistrictId"));
		}

		if (!map.get("filtrByCategoryId").equals("0") ){
			
			// example IN (n.sections) AS s WHERE s.id=
			resultString += ", IN (p.categories) AS s WHERE s.categId=" + map.get("filtrByCategoryId")	;	
			resultString += (wasFiltr+fString);

		}else if (fString.length()>0){
			resultString += (" WHERE "+fString);
		}
		
		String sort = map.get("sortBy");
		switch (sort) {
			case "noSort" : 
				resultString += ""; 
				break;
			case "creationDate" : 
				resultString += " ORDER BY p.creationDate DESC"; 
				break;
			// Need To Form Table with Proposal & Sort *Here*?
// ***************************************put you code here******************************************
				
				
				
// ***************************************put you code here******************************************				
			case "voteCount" : 
				resultString += ""; 
				break;
			case "commentCount" : 
				resultString += ""; 
				break;
		}
		
		return resultString;
	}
	
	
	
	
	@Override
	public RequestResult findByParams(HashMap<String,String> map) {
		
		String mainQuery = queryBuilder(map);
		String queryText = "";
		
		queryText = "SELECT COUNT(*) FROM Proposal p" + mainQuery;
		logger.info("queryText:  " + queryText);
		Query query1 = em.createQuery(queryText);
		long resultSize =(long) query1.getSingleResult();
		logger.info("resultSize:  " + resultSize); 
		
		
		queryText = "SELECT p FROM Proposal p" + mainQuery;
		logger.info("queryText:  " + queryText); 
		TypedQuery<Proposal> query2 = em.createQuery(queryText, Proposal.class);
		//calculate paging
		int pageNum = Integer.parseInt(map.get("pageNum"));
		int pageQuant = Integer.parseInt(map.get("pageQuant"));
		long first = (pageNum-1)*pageQuant;
		query2.setFirstResult((int)first);
		query2.setMaxResults(pageQuant);
		List<Proposal> resultList = query2.getResultList();
			
		for (Proposal item : resultList) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		logger.info("resultList:  " + resultList);
		return new RequestResult(resultSize,resultList );
	}




	
	
	
}