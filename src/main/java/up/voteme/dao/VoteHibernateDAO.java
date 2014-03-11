package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.domain.Vote;
import up.voteme.exception.dao.VoteDAOException;
import up.voteme.service.VoteDAO;

import java.util.Date;
import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class VoteHibernateDAO implements VoteDAO {
    @Override
    public void addVote(Vote vote) throws VoteDAOException {
        try {
            begin();
            getSession().save(vote);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new VoteDAOException("Could't add vote! " + vote, e);
        }
    }

    @Override
    public List<Vote> getAllVotesByUser(User user) throws VoteDAOException {
        List<Vote> votes;
        try {
            begin();
            int userId = user.getId();
            votes = (List<Vote>) getSession().createQuery("from Vote where user_id =:userId")
                    .setInteger("userId", userId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new VoteDAOException("Could't get all votes by user!" + user, e);
        }
        return votes;
    }

    @Override
    public List<Vote> getAllVotesByProposal(Proposal proposal) throws VoteDAOException {
        List<Vote> votes;
        try {
            begin();
            int proposalId = proposal.getId();
            votes = (List<Vote>) getSession().createQuery("from Vote where proposal_id =:proposalId")
                    .setInteger("proposalId", proposalId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new VoteDAOException("Could't get all votes by proposal!" + proposal, e);
        }
        return votes;
    }

    @Override
    public List<Vote> getAllVotesByDate(Date date) throws VoteDAOException {
        List<Vote> votes;
        try {
            begin();
            votes = (List<Vote>) getSession().createQuery("from Vote where date =:date")
                    .setDate("date", date)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new VoteDAOException("Could't get all votes by date!" + date, e);
        }
        return votes;
    }
}
