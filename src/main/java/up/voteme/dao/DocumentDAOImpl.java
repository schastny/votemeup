package up.voteme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import up.voteme.domain.Document;

@Component
public class DocumentDAOImpl implements IDocumentDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public long store(Document document) {
		long id = manager.merge(document).getDocId();
		return id;
	}

	@Override
	public void delete(Long id) {
		Document document = manager.find(Document.class, id);
		manager.remove(document);
	}

	@Override
	public List<Document> findAll() {
		TypedQuery<Document> query = manager.createQuery(
				"SELECT d FROM Document d", Document.class);
		List<Document> docs = query.getResultList();
//		for (Document doc : docs) {
//			
//			System.out.println(doc);
//		}

		return docs;
	}

	@Override
	public Document findById(Long id) {
		return manager.find(Document.class, id);
	}
}