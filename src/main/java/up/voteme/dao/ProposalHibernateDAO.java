package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.exception.dao.ProposalDAOException;
import up.voteme.service.ProposalDAO;
import up.voteme.util.HibernateUtil;

import java.util.Date;
import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class ProposalHibernateDAO implements ProposalDAO
{
    @Override
    public void addProposal(Proposal proposal) throws ProposalDAOException
    {
        try
        {
            begin();
            getSession().save(proposal);
            commit();
            closeSession();
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
            begin();
            getSession().delete(proposal);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new ProposalDAOException("Could't delete proposal! " + proposal, e);
        }
    }

    @Override
    public Proposal getProposal(int id) throws ProposalDAOException
    {
        Proposal proposal = null;
        try
        {
            begin();
            proposal = (Proposal)getSession().get(Proposal.class, id);
            commit();
            closeSession();
        } catch(HibernateException e)
        {
            rollback();
            throw new ProposalDAOException("Could't get proposal by ID!" + id, e);
        }
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
