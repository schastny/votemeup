package up.voteme.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Proposal;

@Component
public class ProposalDAOImpl implements ProposalDAO {
	

	@PersistenceContext
	private EntityManager em;
		
	
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
		
		// Analize HashMap & Form the Query text
		if (map.size() == 0) {
			queryText = "SELECT p FROM Proposal AS p";
		}
		else {
			/* PARAMETERS:
			sortBy = {noSort, voteCount, creationDate, commentCount};
			pageNum = {1..countAll() / PageQuant};
			pageQuant = {10,25,50};
			filtrByLevel = {noSort, Collection: proposalLevel.findAll().getLevel};
			filtrByStatus = {noSort, Collection: proposalStatus.findAll().getStatus};
			filtrByCategory = {noSort, Collection: proposalCategory.findAll().getCategoryName()};
			filtrByCountry = {noSort, Collection: country.findAll().getCountryName};
			filtrByRegion = {noSort, Collection: region.findAll().get..};
			filtrByCity = {noSort, Collection: city.findAll().get..};
			filtrByDistrict = {noSort, Collection: district.findAll().get..};			
			*/
			
			if (map.containsKey("sortBy")) {
				String sortString = " ORDER BY ";
				
				String sort = map.get("sortBy");
				
				switch (sort) {
					case "creationDate" : sortString = sortString + "p.creationDate"; break;
					default : ;
				}
				
				// queryText = queryText + sortString; // debugging
				
				if (sort != "noSort") {
					queryText = queryText + sortString;
				}
				
			}
			
		// System.out.println(queryText); // debugging
			
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