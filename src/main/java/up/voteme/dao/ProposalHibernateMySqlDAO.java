package up.voteme.dao;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.service.ProposalDAO;

import java.util.Date;
import java.util.List;

public class ProposalHibernateMySqlDAO implements ProposalDAO
{
    @Override
    public void addProposal(Proposal proposal)
    {

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
