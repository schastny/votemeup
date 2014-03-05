package up.voteme.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import up.voteme.domain.Attachment;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.service.AttachmentDAO;
import up.voteme.util.HibernateUtil;

import java.util.List;

public class AttachmentHibernateDAO implements AttachmentDAO
{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addAttachment(Attachment attachment)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(attachment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAttachment(Attachment attachment)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(attachment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Attachment getAttachment(int id)
    {
        Attachment attachment = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        attachment = (Attachment)session.get(Attachment.class, id);

        session.getTransaction().commit();
        session.close();
        return attachment;
    }

    @Override
    public List<Attachment> getAllAttachmentsByProposal(Proposal proposal)
    {
        List<Attachment> attachments = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Attachment.class);
        criteria.add(Restrictions.eq("proposal", proposal));
        attachments = criteria.list();

        session.getTransaction().commit();
        session.close();

        return attachments;
    }

    @Override
    public List<Attachment> getAllAttachmentsByComment(Comment comment)
    {
        return null;
    }
}
