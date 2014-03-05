package up.voteme.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.Attachment;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;
import up.voteme.service.AttachmentDAO;
import up.voteme.util.HibernateUtil;

import java.util.List;

public class AttachmentHibernateMySqlDAO implements AttachmentDAO
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //TODO !!!!! !
//        session.
//        session.getTransaction().commit();
//        session.close();
        return null;
    }

    @Override
    public List<Attachment> getAllAttachmentsByProposal(Proposal proposal)
    {
        return null;
    }

    @Override
    public List<Attachment> getAllAttachmentsByComment(Comment comment)
    {
        return null;
    }
}
