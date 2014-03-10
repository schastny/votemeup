package up.voteme.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.domain.User;
import up.voteme.exception.dao.ProposalDAOException;
import up.voteme.service.ProposalDAO;
import up.voteme.util.HibernateUtil;

import java.util.Date;
import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class ProposalHibernateDAO implements ProposalDAO {
    @Override
    public void addProposal(Proposal proposal) throws ProposalDAOException {
        try {
            begin();
            getSession().save(proposal);
            commit();
            closeSession();
        } catch(HibernateException e) {
            HibernateUtil.rollback();
            throw new ProposalDAOException("Could't add proposal! " + proposal, e);
        }
    }

    @Override
    public void deleteProposal(Proposal proposal) throws ProposalDAOException {
        try {
            begin();
            getSession().delete(proposal);
            commit();
            closeSession();
        } catch(HibernateException e) {
            HibernateUtil.rollback();
            throw new ProposalDAOException("Could't delete proposal! " + proposal, e);
        }
    }

    @Override
    public Proposal getProposal(int id) throws ProposalDAOException {
        Proposal proposal = null;
        try {
            begin();
            proposal = (Proposal) getSession().get(Proposal.class, id);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new ProposalDAOException("Could't get proposal by ID!" + id, e);
        }
        return proposal;
    }

    @Override
    public void updateProposal(int id) {

    }

    @Override
    public List<Proposal> getUserProposals(User user) throws ProposalDAOException {
        List<Proposal> proposals;
        try {
            begin();
            int userId = user.getId();
            proposals = (List<Proposal>) getSession().createQuery("from Proposal where user_id =:userId")
                    .setInteger("userId", userId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new ProposalDAOException("Could't get all proposals by user!" + user, e);
        }
        return proposals;
    }

    @Override
    public List<Proposal> getProposalsByTag(Tag tag) throws ProposalDAOException {

        List<Proposal> proposals;
        try {
            begin();

            int tagId = tag.getId();
            Query query = getSession().createQuery(
                    " select proposal "
                            + " from Proposal proposal INNER JOIN proposal.tags tag"
                            + " where tag.id=:tagId "
            );
            query.setInteger("tagId", tagId);
            proposals = (List<Proposal>) query.list();

            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new ProposalDAOException("Could't get all proposals by tag! " + tag, e);
        }
        return proposals;
    }

    @Override
    public List<Proposal> getProposalsByCategory(Category category) {
        return null;
    }

    @Override
    public List<Proposal> getProposalsByDueDate(Date dueDate) throws ProposalDAOException {
        List<Proposal> proposals;
        try {
            begin();
            proposals = (List<Proposal>) getSession().createQuery("from Proposal where date =:date")
                    .setDate("date", dueDate)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new ProposalDAOException("Could't get all votes by dueDate!" + dueDate, e);
        }
        return proposals;
    }

    @Override
    public List<Proposal> getProposalsByCreationalDate(Date creationalDate) throws ProposalDAOException {
        List<Proposal> proposals;
        try {
            begin();
            proposals = (List<Proposal>) getSession().createQuery("from Proposal where date =:date")
                    .setDate("date", creationalDate)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new ProposalDAOException("Could't get all votes by creationalDate!" + creationalDate, e);
        }
        return proposals;
    }
}
