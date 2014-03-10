package up.voteme.service;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.exception.dao.ProposalDAOException;

import java.util.Date;
import java.util.List;

public interface ProposalDAO
{
    public void addProposal(Proposal proposal) throws ProposalDAOException;

    public void deleteProposal(Proposal proposal) throws ProposalDAOException;

    public Proposal getProposal(int id) throws ProposalDAOException;

    public void updateProposal(int id) throws ProposalDAOException;

    public List<Proposal> getUserProposals(int userId) throws ProposalDAOException;

    public Proposal getProposalByTag(Tag tag) throws ProposalDAOException;

    public Proposal getProposalByCategory(Category category) throws ProposalDAOException;

    public Proposal getProposalByDueDate(Date dueDate) throws ProposalDAOException;

    public Proposal getProposalByCreationalDate(Date creationalDate) throws ProposalDAOException;
}
