package up.voteme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import up.voteme.dao.IDocumentDAO;
import up.voteme.domain.Document;

public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private IDocumentDAO documentDAO;

	@Transactional
	@Override
	public void store(Document document) {
		documentDAO.store(document);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		documentDAO.delete(id);
	}

	@Transactional
	@Override
	public Document findById(Long id) {
		return documentDAO.findById(id);
	}

	@Transactional
	@Override
	public List<Document> findAll() {
		return documentDAO.findAll();
	}

}
