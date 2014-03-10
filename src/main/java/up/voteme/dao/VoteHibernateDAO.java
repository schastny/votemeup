package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.domain.Vote;
import up.voteme.exception.dao.VoteDAOException;
import up.voteme.service.VoteDAO;
import up.voteme.util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class VoteHibernateDAO implements VoteDAO
{
    @Override
    public void addVote(Vote vote) throws VoteDAOException
    {
        try
        {
            HibernateUtil.begin();
            HibernateUtil.getSession().save(vote);
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new VoteDAOException("Could't add vote! " + vote, e);
        }
    }

    @Override
    public List<Vote> getAllVotesByUser(User user) throws VoteDAOException
    {
        List<Vote> votes;
        try
        {
            HibernateUtil.begin();
            int userId = user.getId();
            votes = (List<Vote>) HibernateUtil.getSession().createQuery("from Vote where user_id =:userId")
                                              .setInteger("userId", userId)
                                              .list();
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new VoteDAOException("Could't get all votes by user!" + user, e);
        }
        return votes;
    }

    @Override
    public List<Vote> getAllVotesByProposal(Proposal proposal) throws VoteDAOException
    {
        List<Vote> votes;
        try
        {
            HibernateUtil.begin();
            int proposalId = proposal.getId();
            votes = (List<Vote>) HibernateUtil.getSession().createQuery("from Vote where proposal_id =:proposalId")
                                                        .setInteger("proposalId", proposalId)
                                                        .list();
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new VoteDAOException("Could't get all votes by proposal!" + proposal, e);
        }
        return votes;
    }

    @Override
    public List<Vote> getAllVotesByDate(Date date) throws VoteDAOException
    {
        List<Vote> votes;
        try
        {
            HibernateUtil.begin();
            votes = (List<Vote>) HibernateUtil.getSession().createQuery("from Vote where date =:date")
                                              .setDate("date", date)
                                              .list();
            HibernateUtil.commit();
            HibernateUtil.closeSession();
        } catch(HibernateException e)
        {
            HibernateUtil.rollback();
            throw new VoteDAOException("Could't get all votes by date!" + date, e);
        }
        return votes;
    }
}
