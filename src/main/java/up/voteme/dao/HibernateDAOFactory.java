package up.voteme.dao;

import up.voteme.service.*;

public class HibernateDAOFactory extends DAOFactory
{

    @Override
    public AttachmentDAO createAttachmentDAO()
    {
        return new AttachmentHibernateDAO();
    }

    @Override
    public CategoryDAO createCategoryDAO()
    {
        return new CategoryHibernateDAO();
    }

    @Override
    public CommentDAO createCommentDAO()
    {
        return new CommentHibernateDAO();
    }

    @Override
    public ProposalDAO createProposalDAO()
    {
        return new ProposalHibernateDAO();
    }

    @Override
    public RoleDAO createRoleDAO()
    {
        return new RoleHibernateDAO();
    }

    @Override
    public TagDAO createTagDAO()
    {
        return new TagHibernateDAO();
    }

    @Override
    public UserDAO createUserDAO()
    {
        return new UserHibernateDAO();
    }

    @Override
    public VoteDAO createVoteDAO()
    {
        return new VoteHibernateDAO();
    }
}
