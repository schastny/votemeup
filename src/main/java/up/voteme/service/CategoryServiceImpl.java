package up.voteme.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.CategoryDAO;
import up.voteme.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
    @Autowired
    private CategoryDAO categoryDAO;
    
    /* (non-Javadoc)
	 * @see up.voteme.service.CategoryService#getAll()
	 */
    @Override
	public List<Category> getAll() {

        return categoryDAO.findAll();
    }
    
    @Override
	@Transactional
    public void delete(long id) {

    	categoryDAO.delete(id);
        
    }
    
}