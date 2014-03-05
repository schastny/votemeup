package up.voteme.service;

import up.voteme.domain.Category;
import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;

import java.util.Date;
import java.util.List;

public interface ProposalDAO
{
    public void addProposal(Proposal proposal);
    public void deleteProposal(Proposal proposal);
    public Proposal getProposal(int id);
    public void updateProposal(int id);
    public List<Proposal> getUserProposals(int userId);
    public Proposal getProposalByTag(Tag tag);
    public Proposal getProposalByCategory(Category category);
    public Proposal getProposalByDueDate(Date dueDate);
    public Proposal getProposalByCreationalDate(Date creationalDate);
}
