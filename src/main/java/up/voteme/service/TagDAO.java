package up.voteme.service;

import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;

import java.util.List;

public interface TagDAO
{
    public void addTag(Tag tag);

    public void deleteTag(Tag tag);

    public Tag getTag(int id);

    public List<Tag> getAllTagsByProposal(Proposal proposal);

    public List<Tag> getAllTags();

    public void updateTag(int id);
}
