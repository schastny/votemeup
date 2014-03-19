package up.voteme.service;

import java.util.List;

import up.voteme.domain.Category;

public interface CategoryService {

	public abstract List<Category> getAll();

	public abstract void delete(long id) ;

}