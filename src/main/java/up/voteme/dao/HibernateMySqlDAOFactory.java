package up.voteme.dao;

import up.voteme.service.*;

public class HibernateMySqlDAOFactory extends DAOFactory
{

    @Override
    public AttachmentDAO createAttachmentDAO()
    {
        return new AttachmentHibernateMySqlDAO();
    }

    @Override
    public CategoryDAO createCategoryDAO()
    {
        return new CategoryHibernateMySqlDAO();
    }

    @Override
    public CommentDAO createCommentDAO()
    {
        return new CommentHibernateMySqlDAO();
    }

    @Override
    public ProposalDAO createProposalDAO()
    {
        return new ProposalHibernateMySqlDAO();
    }

    @Override
    public RoleDAO createRoleDAO()
    {
        return new RoleHibernateMySqlDAO();
    }

    @Override
    public TagDAO createTagDAO()
    {
        return new TagHibernateMySqlDAO();
    }

    @Override
    public UserDAO createUserDAO()
    {
        return new UserHibernateMySqlDAO();
    }

    @Override
    public VoteDAO createVoteDAO()
    {
        return new VoteHibernateMySqlDAO();
    }
}
