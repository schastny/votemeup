package up.voteme.service;

import up.voteme.domain.Proposal;
import up.voteme.domain.Tag;
import up.voteme.exception.dao.TagDAOException;

import java.util.List;

public interface TagDAO {
    public void addTag(Tag tag) throws TagDAOException;

    public void deleteTag(Tag tag) throws TagDAOException;

    public Tag getTag(int id) throws TagDAOException;

    public List<Tag> getAllTagsByProposal(Proposal proposal) throws TagDAOException;

    public List<Tag> getAllTags() throws TagDAOException;

    public void updateTag(Tag tag) throws TagDAOException;
}
