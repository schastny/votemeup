package up.voteme.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;
import up.voteme.service.VoteService;

@Component
public class ProposalDAOImpl implements ProposalDAO {
	

	@PersistenceContext
	private EntityManager em;
		
	@Autowired
	VoteDAO voteDAO;

	
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
	public Proposal findById(long id) {
		 return em.find(Proposal.class, id);
		
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
	
	@Override
	public RequestResult findByParams(HashMap<String,String> map) {
		
		
		String queryText = "";
		
System.out.println("!!!!!!!!!!!!!!!!!!!! map = "+map);		

		
		String sortString = " ";
		String queryVote = " ";


		// (1) Analize HashMap & Form the Query text
		if (map.size() != 0) { // If The Parameters Of Sorting Are Exist
			Boolean flFilter = false;

			if (map.containsKey("filterByCategoryId")) {
				if (Integer.parseInt(map.get("filterByCategoryId")) != 0 ) {
						queryText = queryText + ", IN (p.categories) AS s WHERE s.categId=" + map.get("filterByCategoryId");
						flFilter = true;
				}
			}
			
			
			
			if (map.containsKey("filterByLevelId")) {
				if (Integer.parseInt(map.get("filterByLevelId")) != 0 ) {
					if (flFilter == false) {
						queryText = queryText + " WHERE p.proposalLevel.id=" + map.get("filterByLevelId");
						flFilter = true;
					}	
					else {
						queryText = queryText + " AND p.proposalLevel.id=" + map.get("filterByLevelId");
					}
				}
			}

			if (map.containsKey("filterByStatusId")) {
				if (Integer.parseInt(map.get("filterByStatusId")) != 0 ) {
					if (flFilter == false) {
						queryText = queryText + " WHERE p.proposalStatus.id=" + map.get("filterByStatusId");
						flFilter = true;
					}	
					else {
						queryText = queryText + " AND p.proposalStatus.id=" + map.get("filterByStatusId");
					}
				}
			}


				if (map.containsKey("filterByCountryId")) {
					long tmp = Long.parseLong(map.get("filterByCountryId"));
					
					if (tmp != 0 ) {
						if (flFilter == false) {
							queryText = queryText + " WHERE p.country.countryId=" + tmp;
							flFilter = true;
						}	
						else {
							queryText = queryText + " AND p.country.countryId=" + tmp;
						}
					}
				}

			if (map.containsKey("filterByRegionId")) {
				if (Integer.parseInt(map.get("filterByRegionId")) != 0 ) {
					if (flFilter == false) {
						queryText = queryText + " WHERE p.region.regionId=" + map.get("filterByRegionId");
						flFilter = true;
					}	
					else {
						queryText = queryText + " AND p.region.regionId=" + map.get("filterByRegionId");
					}
				}
			}

			if (map.containsKey("filterByCityId")) {
				if (Integer.parseInt(map.get("filterByCityId")) != 0 ) {
					if (flFilter == false) {
						queryText = queryText + " WHERE p.city.cityId=" + map.get("filterByCityId");
						flFilter = true;
					}	
					else {
						queryText = queryText + " AND p.city.cityId=" + map.get("filterByCityId");
					}
				}
			}

			if (map.containsKey("filterByDistrictId")) {
				if (Integer.parseInt(map.get("filterByDistrictId")) != 0 ) {
					if (flFilter == false) {
						queryText = queryText + " WHERE p.district.districtId=" + map.get("filterByDistrictId");
						flFilter = true;
					}	
					else {
						queryText = queryText + " AND p.district.districtId=" + map.get("filterByDistrictId");
					}
				}
			}
	
			if (map.containsKey("sortBy")) {

				String sort = map.get("sortBy");
				
				
				
				switch (sort) {
				case "noSort" : { 
					break;
				}	
				case "creationDate" : {
					sortString = " ORDER BY p.creationDate DESC"; 
					break;
					
				}
				case "voteCount" :{ 
					queryVote = ", (SELECT COUNT(v) FROM  Vote AS v  WHERE p.proposalId = v.proposal) AS vot";
					
//					SELECT u.*, 
//					(select COUNT(user_id) from  friends  where u.id = user_id) AS friends, 
//					(select COUNT(owner_id) from  items where u.id = owner_id) AS items
//					FROM users u					
					
					sortString = " ORDER BY vot DESC "; 
					break;
				}	

				case "commentCount" : {
					sortString = " "; break;
				}
				
				 default : ;
				}
				//queryText = queryText + sortString;
			}
		}
			

		String queryTextProposal = "SELECT p "+queryVote+" FROM Proposal AS p";
		String queryTextCount = "SELECT COUNT(p) FROM Proposal AS p";

		String queryTextProposal2 = "SELECT p "+queryVote+" FROM Proposal AS p";
		
//==============================================================
		Query q = em.createQuery(queryTextProposal2 + queryText + sortString);
//		List<Proposal> results = new ArrayList<Proposal>();
		
		List<Object[]> results = q.getResultList();		

		for(int i = 0 ; i < results.size() ; i++){
			 System.out.println("............ "+ results.get(i));

			}
		
//============================================================================		
		
		System.out.println("**    1  **   " + queryTextCount+queryText); // debugging
		Query queryCount = em.createQuery(queryTextCount+queryText);
		long size =(long) queryCount.getSingleResult();
		
		System.out.println("**    2  **   " + queryTextProposal+queryText + sortString); // debugging
		TypedQuery<Proposal> queryProposal = em.createQuery(queryTextProposal+queryText+sortString, Proposal.class);

		int pageNum = Integer.parseInt(map.get("pageNum"));
		int pageQuant = Integer.parseInt(map.get("pageQuant"));
		long first = (pageNum-1)*pageQuant;
		queryProposal.setFirstResult((int)first);
		queryProposal.setMaxResults(pageQuant);

		List<Proposal> resultList = queryProposal.getResultList();

		for (Proposal item : resultList) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}

		
		
		return new RequestResult(size,resultList);
		
		
		
		
		
		
		
	}
}