package up.voteme.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;
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
	
	@Override
	public List<Proposal> findByParams(HashMap<String,String> map) {
		
		
		String queryText = "SELECT p FROM Proposal p";
		
		/* PARAMETERS:
		sortBy = {noSort, voteCount, creationDate, commentCount};
		pageNum = {1..countAll() / PageQuant};
		pageQuant = {10,25,50};
		filterByLevel = {noSort, Collection: proposalLevel.findAll().getLevel};
		filterByStatus = {noSort, Collection: proposalStatus.findAll().getStatus};
		filterByCategory = {noSort, Collection: proposalCategory.findAll().getCategoryName()};
		filterByCountry = {noSort, Collection: country.findAll().getCountryName};
		filterByRegion = {noSort, Collection: region.findAll().get..};
		filterByCity = {noSort, Collection: city.findAll().get..};
		filterByDistrict = {noSort, Collection: district.findAll().get..};			
		*/
		
System.out.println("!!!!!!!!!!!!!!!!!!!! map = "+map);		
System.out.println("key filterByCountryId = "+map.containsKey("filterByCountryId"));

for (String key : map.keySet()) {
    System.out.println("Key: " + key);
}
		
		
		// (1) Analize HashMap & Form the Query text
		if (map.size() != 0) { // If The Parameters Of Sorting Are Exist
			Boolean flFilter = false;

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

//			if (map.containsKey("filterByCategoryId")) {
//				flFilter = true;
//				filterByCategoryId = "p.category.id=" + map.get("filterByCategoryId");
//			}

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
				String sortString = " ";
				String sort = map.get("sortBy");
				
				
				
				switch (sort) {
				case "noSort" : sortString = " "; break;
				case "creationDate" : sortString = " ORDER BY p.creationDate DESC"; break;
				
				// Need To Form Table with Proposal & Sort *Here*?
	
				case "voteCount" : sortString = "  "; break;
				case "commentCount" : sortString = " "; break;
				
				 default : ;
				}
				queryText = queryText + sortString;
			}
			
		System.out.println("*****   " + queryText); // debugging
			
			}
			
		// Run query
		//queryText = "SELECT p FROM Proposal p"; // debugging
		TypedQuery<Proposal> query = em.createQuery(queryText, Proposal.class);
		
		List<Proposal> items = query.getResultList();
		
		List<Proposal> resultList = new ArrayList<>();
		long size = items.size();
		int pageNum = Integer.parseInt(map.get("pageNum"));
		int pageQuant = Integer.parseInt(map.get("pageQuant"));
		long first = (pageNum-1)*pageQuant;
		long last = first+pageQuant;
		if (last > size){ // last page not full
			last = size;
		}
		for (long i=first; i<last; i++){
			resultList.add(items.get((int)i));
		}		
		
		for (Proposal item : resultList) {
			
			System.out.println(">>>>>>>>   " + item); // debugging
			
			
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return resultList;
	}
}