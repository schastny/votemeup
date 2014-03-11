package up.voteme.service;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.domain.User;
import up.voteme.exception.dao.ProposalDAOException;

import java.util.Date;
import java.util.List;

public interface ProposalDAO {
    public void addProposal(Proposal proposal) throws ProposalDAOException;

    public void deleteProposal(Proposal proposal) throws ProposalDAOException;

    public Proposal getProposal(int id) throws ProposalDAOException;

    public void updateProposal(int id) throws ProposalDAOException;

    public List<Proposal> getUserProposals(User user) throws ProposalDAOException;

    public List<Proposal> getProposalsByTag(Tag tag) throws ProposalDAOException;

    public List<Proposal> getProposalsByCategory(Category category) throws ProposalDAOException;

    public List<Proposal> getProposalsByDueDate(Date dueDate) throws ProposalDAOException;

    public List<Proposal> getProposalsByCreationalDate(Date creationalDate) throws ProposalDAOException;
}
