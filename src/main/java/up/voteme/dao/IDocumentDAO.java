package up.voteme.dao;

import java.util.List;

import up.voteme.domain.Document;

public interface IDocumentDAO {

	public  long store(Document item);

	public  void delete(Long Id);

	public  Document findById(Long Id);

	public  List<Document> findAll();

}