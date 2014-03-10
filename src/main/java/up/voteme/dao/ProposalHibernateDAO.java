package up.voteme.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.exception.dao.ProposalDAOException;
import up.voteme.service.ProposalDAO;
import up.voteme.util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class ProposalHibernateDAO implements ProposalDAO
{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addProposal(Proposal proposal) throws ProposalDAOException
    {
        try
        {
            HibernateUtil.begin();
            HibernateUtil.getSession().save(proposal);
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new ProposalDAOException("Could't add proposal! " + proposal, e);
        }
    }

    @Override
    public void deleteProposal(Proposal proposal) throws ProposalDAOException
    {
        try
        {
            HibernateUtil.begin();
            HibernateUtil.getSession().delete(proposal);
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new ProposalDAOException("Could't delete proposal! " + proposal, e);
        }
    }

    @Override
    public Proposal getProposal(int id)
    {
        Proposal proposal = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        proposal = (Proposal)session.get(Proposal.class, id);
        session.getTransaction().commit();
        session.close();

        return proposal;
    }

    @Override
    public void updateProposal(int id)
    {

    }

    @Override
    public List<Proposal> getUserProposals(int userId)
    {
        return null;
    }

    @Override
    public Proposal getProposalByTag(Tag tag)
    {
        return null;
    }

    @Override
    public Proposal getProposalByCategory(Category category)
    {
        return null;
    }

    @Override
    public Proposal getProposalByDueDate(Date dueDate)
    {
        return null;
    }

    @Override
    public Proposal getProposalByCreationalDate(Date creationalDate)
    {
        return null;
    }
}
