package up.voteme.service;

import java.util.List;

import up.voteme.domain.Document;

public interface DocumentService {
	public void store(Document document);

	public void delete(Long id);

	public Document findById(Long id);

	public List<Document> findAll();

	public List<Document> getDocumentByProposal(Long id);
}
