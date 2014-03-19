package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Category;

public interface CategoryDAO {

	public abstract long store(Category item);

	public abstract void delete(Long categoryId);

	public abstract Category findById(Long categoryId);

	public abstract List<Category> findAll();

	public abstract long countAll();

}