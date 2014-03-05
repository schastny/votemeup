package up.voteme.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.service.ProposalDAO;
import up.voteme.util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class ProposalHibernateDAO implements ProposalDAO
{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addProposal(Proposal proposal)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(proposal);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteProposal(Proposal proposal)
    {

    }

    @Override
    public Proposal getProposal(int id)
    {
        return null;
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
