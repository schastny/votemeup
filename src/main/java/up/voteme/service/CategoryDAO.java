package up.voteme.service;

import up.voteme.domain.Category;
import up.voteme.exception.dao.CategoryDAOException;

import java.util.List;

public interface CategoryDAO {
    public void addCategory(Category category) throws CategoryDAOException;

    public void deleteCategory(Category category) throws CategoryDAOException;

    public Category getCategory(int id) throws CategoryDAOException;

    public List<Category> getAllCategories() throws CategoryDAOException;

    public void updateCategory(int id) throws CategoryDAOException;

}
