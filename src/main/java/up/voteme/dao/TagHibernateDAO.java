package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.exception.dao.TagDAOException;
import up.voteme.service.TagDAO;

import java.util.List;

import static up.voteme.util.HibernateUtil.*;
import static up.voteme.util.HibernateUtil.rollback;

public class TagHibernateDAO implements TagDAO {
    @Override
    public void addTag(Tag tag) throws TagDAOException {
        try {
            begin();
            getSession().save(tag);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new TagDAOException("Could't add tag! " + tag, e);
        }
    }

    @Override
    public void deleteTag(Tag tag) throws TagDAOException {
        try {
            begin();
            getSession().delete(tag);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new TagDAOException("Could't delete tag! " + tag, e);
        }
    }

    @Override
    public Tag getTag(int id) throws TagDAOException {
        Tag tag;
        try {
            begin();
            tag = (Tag) getSession().get(Tag.class, id);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new TagDAOException("Could't get tag by ID!" + id, e);
        }
        return tag;
    }

    @Override
    public List<Tag> getAllTagsByProposal(Proposal proposal) {
        return null;
    }

    @Override
    public List<Tag> getAllTags() {
        return null;
    }

    @Override
    public void updateTag(Tag tag) {

    }
}
