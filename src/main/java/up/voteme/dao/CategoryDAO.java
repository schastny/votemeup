package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Category;

public interface CategoryDAO {

	public abstract long store(Category item);

	public abstract void delete(long categoryId);

	public abstract Category findById(long categoryId);

	public abstract List<Category> findAll();

	public abstract long countAll();

}