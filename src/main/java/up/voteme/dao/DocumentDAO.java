package up.voteme.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import up.voteme.domain.Document;

public class DocumentDAO implements IDocumentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long store(Document document) {
		long id = 1L;
		sessionFactory.getCurrentSession().saveOrUpdate(document);
		return id;
	}

	@Override
	public void delete(Long id) {
		Document document = findById(id);
		if (document != null) {
			sessionFactory.getCurrentSession().delete(document);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Document> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Document")
				.list();
	}

	@Override
	public Document findById(Long Id) {
		return (Document) sessionFactory.getCurrentSession().get(
				Document.class, Id);
	}
}