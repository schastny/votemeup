package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Document;

public interface IDocumentDAO {

	public abstract long store(Document item);

	public abstract void delete(Long Id);

	public abstract Document findById(Long Id);

	public abstract List<Document> findAll();

}