package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Category;
import up.voteme.exception.dao.CategoryDAOException;
import up.voteme.service.CategoryDAO;

import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class CategoryHibernateDAO implements CategoryDAO
{
    @Override
    public void addCategory(Category category) throws CategoryDAOException
    {
        try
        {
            begin();
            getSession().save(category);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new CategoryDAOException("Could't add category!" + category, e);
        }
    }

    @Override
    public void deleteCategory(Category category) throws CategoryDAOException
    {
        try
        {
            begin();
            getSession().delete(category);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new CategoryDAOException("Could't delete category!" + category, e);
        }
    }

    @Override
    public Category getCategory(int id) throws CategoryDAOException
    {
        Category category;
        try
        {
            begin();
            category = (Category)getSession().get(Category.class, id);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new CategoryDAOException("Could't get category by ID!" + id, e);
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories() throws CategoryDAOException
    {
        List<Category> categories = null;
        try
        {
            begin();
            categories = (List<Category>)getSession().createCriteria(Category.class).list();
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new CategoryDAOException("Could't get all categories!", e);
        }
        return categories;
    }

    @Override
    public void updateCategory(int id) throws CategoryDAOException
    {

    }
}
