package up.voteme.dao;

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
		
		
		
		// (1) Analize HashMap & Form the Query text
		if (map.size() != 0) { // If The Parameters Of Sorting Are Exist
			if (map.containsKey("sortBy")) {
				String sortString = " ";
				String sort = map.get("sortBy");
				
				
				
				switch (sort) {
				case "noSort" : sortString = " "; break;
				case "creationDate" : sortString = " ORDER BY p.creationDate"; break;
				
				// Need To Form Table with Proposal & Sort *Here*?
	
				case "voteCount" : sortString = "  "; break;
				case "commentCount" : sortString = " "; break;
				
				 default : ;
				}
				queryText = queryText + sortString;
			}
			
			// Does Filter Exist?
			Boolean flFilter = false;
			// String filterString = " WHERE p.";
			String filterString = "";
			
			String filterByLevelId = ""; 
			String filterByStatusId = ""; 
			String filterByCategoryId = ""; 
			String filterByCountryId = ""; 
			String filterByRegionId = ""; 
			String filterByCityId = ""; 
			String filterByDistrictId = ""; 

			if (map.containsKey("filterByLevelId")) {
				flFilter = true;
				filterByLevelId = "p.level.id=" + map.get("filterByLevelId");
			}

			if (map.containsKey("filterByStatusId")) {
				flFilter = true;
				filterByStatusId = "p.proposal_status_id=" + map.get("filterByStatusId");
			}

			if (map.containsKey("filterByCategoryId")) {
				flFilter = true;
				filterByCategoryId = "p.category.id=" + map.get("filterByCategoryId");
			}

			if (map.containsKey("filterByCountryId")) {
				flFilter = true;
				filterByCountryId = "p.country.id=" + map.get("filterByCountryId");
			}

			if (map.containsKey("filterByRegionId")) {
				flFilter = true;
				filterByRegionId = "p.region.id=" + map.get("filterByRegionId");
			}

			if (map.containsKey("filterByCityId")) {
				flFilter = true;
				filterByCityId = "p.city.id=" + map.get("filterByCityId");
			}

			if (map.containsKey("filterByDistrictId")) {
				flFilter = true;
				filterByDistrictId = "p.district.id="	+ map.get("filterByDistrictId");
			}
	
			Boolean wasFilters = false;
			String wasFiltersStr = " ";

			if (flFilter == true) {
				// queryText = queryText + filterString;
				queryText = queryText + " WHERE ";

				if (!(filterByLevelId.isEmpty())) {
					queryText = queryText + filterByLevelId;
					wasFiltersStr = " AND ";
				}

				if (!(filterByStatusId.isEmpty())) {
					queryText = queryText + wasFiltersStr + filterByStatusId;
					wasFiltersStr = " AND ";
				}

				if (!(filterByCategoryId.isEmpty())) {
					queryText = queryText + wasFiltersStr + filterByCategoryId;
					wasFiltersStr = " AND ";
				}

				if (!(filterByCountryId.isEmpty())) {
					queryText = queryText + wasFiltersStr + filterByCountryId;
					wasFiltersStr = " AND ";
				}

				if (!(filterByRegionId.isEmpty())) {
					queryText = queryText + wasFiltersStr + filterByRegionId;
					wasFiltersStr = " AND ";
				}

				if (!(filterByDistrictId.isEmpty())) {
					queryText = queryText + wasFiltersStr + filterByDistrictId;
					wasFiltersStr = " AND "; // not need (last par-r)
				}
			}
			
		System.out.println("*****   " + queryText); // debugging
			
			}
			
		// Run query
		//queryText = "SELECT p FROM Proposal p"; // debugging
		TypedQuery<Proposal> query = em.createQuery(queryText, Proposal.class);
		
		List<Proposal> items = query.getResultList();
		
		for (Proposal item : items) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
		return items;
	}
}