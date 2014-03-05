package up.voteme.service;

import up.voteme.domain.Category;

import java.util.List;

public interface CategoryDAO
{
    public void addCategory(Category category);

    public void deleteCategory(Category category);

    public Category getCategory(int id);

    public List<Category> getAllCategories();

    public void updateCategory(int id);

}
