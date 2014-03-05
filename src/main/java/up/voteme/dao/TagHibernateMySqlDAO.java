package up.voteme.dao;

import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.service.TagDAO;

import java.util.List;

public class TagHibernateMySqlDAO implements TagDAO
{
    @Override
    public void addTag(Tag tag)
    {

    }

    @Override
    public void deleteTag(Tag tag)
    {

    }

    @Override
    public Tag getTag(int id)
    {
        return null;
    }

    @Override
    public List<Tag> getAllTagsByProposal(Proposal proposal)
    {
        return null;
    }

    @Override
    public List<Tag> getAllTags()
    {
        return null;
    }

    @Override
    public void updateTag(int id)
    {

    }
}
