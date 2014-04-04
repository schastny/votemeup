package up.voteme.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;






import javax.persistence.criteria.SetJoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import up.voteme.domain.Category;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.model.RequestResult;

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
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Proposal> cq = cb.createQuery(Proposal.class); 
        Root<Proposal> proposal = cq.from(Proposal.class); 
		
		Set<String> expectedSet = new HashSet<>();
		expectedSet.add("sortBy");
		expectedSet.add("pageNum");
		expectedSet.add("pageQuant");
		expectedSet.add("filtrByStatusId");
		expectedSet.add("filtrByLevelId");
		expectedSet.add("filtrByCategoryId");
		expectedSet.add("filtrByCountryId");
		expectedSet.add("filtrByRegionId");
		expectedSet.add("filtrByCityId");
		expectedSet.add("filtrByDistrictId");
		if (!map.keySet().containsAll(expectedSet)){
			throw new RuntimeException("Configuration map is uncorrect");
		}
				
		Predicate predicate = cb.conjunction();
		if (!map.get("filtrByStatusId").equals("0") ){
			Predicate np = cb.equal(proposal.get("proposalStatus").get("id"), map.get("filtrByStatusId") );
		    predicate = cb.and(predicate, np);
		}
		if (!map.get("filtrByLevelId").equals("0") ){
			Predicate np = cb.equal(proposal.get("proposalLevel").get("id"), map.get("filtrByLevelId") );
		    predicate = cb.and(predicate, np);
		}
		if (!map.get("filtrByCountryId").equals("0") ){
			Predicate np = cb.equal(proposal.get("country").get("countryId"), map.get("filtrByCountryId") );
		    predicate = cb.and(predicate, np);
		}
		if (!map.get("filtrByRegionId").equals("0") ){
			Predicate np = cb.equal(proposal.get("region").get("regionId"), map.get("filtrByRegionId") );
		    predicate = cb.and(predicate, np);
		}
		if (!map.get("filtrByCityId").equals("0") ){
			Predicate np = cb.equal(proposal.get("city").get("cityId"), map.get("filtrByCityId") );
		    predicate = cb.and(predicate, np);
		}
		if (!map.get("filtrByDistrictId").equals("0") ){
			Predicate np = cb.equal(proposal.get("district").get("districtId"), map.get("filtrByDistrictId") );
		    predicate = cb.and(predicate, np);
		}
		 
		
		
		/*
		CriteriaQuery<Department> q = cb.createQuery(Department.class);
		Root<Department> dept = q.from(Department.class);
		Join<Department,Employee> emp = d.join(Department_.employees);
		q.where(cb.equal(emp.get(Employee_.name),"edalorzo"));
		*/
		Join<Proposal,Category> categories = proposal.join("categories");
		if (!map.get("filtrByCategoryId").equals("0") ){

			Predicate np = cb.equal(categories.get("categId") ,map.get("filtrByCategoryId"));
			predicate = cb.and(predicate, np);		
		}
		
		if (predicate != null) {
			cq.where(predicate);
		}
		logger.info("predicate:  " + predicate);
		
		String sort = map.get("sortBy");
		switch (sort) {
			case "noSort" : 
				break;
			case "creationDate" : 
				cq.orderBy (cb.desc(proposal.get("creationDate")));
				break;
			case "voteCount" : 
				cq.orderBy(cb.desc(cb.size(proposal.<Collection<Comment>>get("votes"))));
				break;
			case "commentCount" : 
				cq.orderBy(cb.desc(cb.size(proposal.<Collection<Comment>>get("comments")))); 
				break;
		}
		
        cq.select(proposal);       
        TypedQuery<Proposal> q = em.createQuery(cq); 
        int pageNum = Integer.parseInt(map.get("pageNum"));
		int pageQuant = Integer.parseInt(map.get("pageQuant"));
		long first = (pageNum-1)*pageQuant;
		q.setFirstResult((int)first);
		q.setMaxResults(pageQuant);
        List<Proposal> resultList = q.getResultList(); 
        for (Proposal item : resultList) {
			item.getCategories().size();
			item.getComments().size();
			item.getVotes().size();
			item.getDocuments().size();
		}
        
        CriteriaQuery<Long> cq2 = cb.createQuery(Long.class);
//        Root<Proposal> prop = cq2.from(Proposal.class); 
        cq2.select(cb.count(cq2.from(Proposal.class)));
        em.createQuery(cq2);
        cq2.where(predicate);
        Long resultSize = em.createQuery(cq2).getSingleResult();
	
	logger.info("resultSize: "+resultSize+" / "+"resultList:  " + resultList);
	return new RequestResult(resultSize, resultList);

	}
	
	
}