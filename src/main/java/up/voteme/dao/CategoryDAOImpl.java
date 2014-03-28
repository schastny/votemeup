package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;


import up.voteme.domain.Category;

@Component
public class CategoryDAOImpl implements CategoryDAO {
	
	@PersistenceContext
	private EntityManager em;
		
	@Override
	public long store(Category item) {
		long id= em.merge(item).getCategId();	//store-update
		return id;
	}
	
	
	@Override
	public void delete(long categoryId) {
		Category category = em.find(Category.class, categoryId);
		em.remove(category);
	}
		
	
	@Override
	public Category findById(long categoryId) {
		 return em.find(Category.class, categoryId);
		
	}
	
	
	@Override
	public List<Category> findAll() {
		TypedQuery<Category> query = em.createQuery(
		"SELECT c FROM Category c", Category.class);
		List<Category> items = query.getResultList();
		for (Category item : items) {
			item.getProposals().size();
		}
		return items;
	}
	
	
	@Override
	public long countAll() {
		Query query = em.createQuery("select count(*) from Category");
		long result = (long) query.getSingleResult();
		return result;
	}
}