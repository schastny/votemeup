package up.voteme.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;

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
		
//		System.out.println("!!!!!!!!!!!!!!!!!!!! map = "+map);		
		
		String queryText = "";
		String sortString = "";
		String queryVote = "";


		if (map.size() != 0) { 
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
					
					sortString = " ORDER BY vot DESC "; 
					break;
				}	

				case "commentCount" : {
					queryVote = ", (SELECT COUNT(v) FROM  Comment AS v  WHERE p.proposalId = v.proposal) AS vot";
					
					sortString = " ORDER BY vot DESC "; 
					break;
				}
				
				 default : ;
				}
				//queryText = queryText + sortString;
			}
		}

		String queryTextCount = "SELECT COUNT(p) FROM Proposal AS p";
		System.out.println("**    1  **   " + queryTextCount+queryText); // debugging
		Query queryCount = em.createQuery(queryTextCount+queryText);
		long size =(long) queryCount.getSingleResult();
		List<Proposal> resultList = new ArrayList<Proposal>();

		if (queryVote.isEmpty()) {
			String queryTextProposal = "SELECT p FROM Proposal AS p";
			System.out.println("**    2  **   " + queryTextProposal+queryText + sortString); // debugging
			TypedQuery<Proposal> queryProposal = em.createQuery(queryTextProposal+queryText+sortString, Proposal.class);
			int pageNum = Integer.parseInt(map.get("pageNum"));
			int pageQuant = Integer.parseInt(map.get("pageQuant"));
			long first = (pageNum-1)*pageQuant;
			queryProposal.setFirstResult((int)first);
			queryProposal.setMaxResults(pageQuant);
	
			resultList = queryProposal.getResultList();
			
		}	
		else {
			String queryTextProposal = "SELECT p.proposalId"+queryVote+" FROM Proposal AS p";
			Query qvr = em.createQuery(queryTextProposal + queryText + sortString);
			int pageNum = Integer.parseInt(map.get("pageNum"));
			int pageQuant = Integer.parseInt(map.get("pageQuant"));
			long first = (pageNum-1)*pageQuant;
			qvr.setFirstResult((int)first);
			qvr.setMaxResults(pageQuant);

			List<Object[]> results = qvr.getResultList();
			System.out.println(results.size());
			System.out.println(results.getClass());

			for (int i = 0; i < results.size(); i++) {
				System.out.println("---------" + results.get(i)[0].getClass()
						+ "  --------- " + (Long) results.get(i)[0]);
				System.out.println(">>>>>>>>>" + results.get(i)[1].getClass()
						+ "  >>>>>>>>> " + (Long) results.get(i)[1]);

				resultList.add(findById((Long) results.get(i)[0]));

			}
				
		}


		for (Proposal item : resultList) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}

		
		
		return new RequestResult(size,resultList);
		
		
		
		
		
		
		
	}
}