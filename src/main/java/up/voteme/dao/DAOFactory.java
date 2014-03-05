package up.voteme.dao;

import up.voteme.service.*;

public abstract class DAOFactory
{
    public static final int HibernateMySqlDAO = 0;

    public static DAOFactory getFactory(int whichFactory)
    {
        switch(whichFactory)
        {
            case HibernateMySqlDAO : return new HibernateMySqlDAOFactory();

            default: return new HibernateMySqlDAOFactory();
        }
    }

    public abstract AttachmentDAO createAttachmentDAO();
    public abstract CategoryDAO createCategoryDAO();
    public abstract CommentDAO createCommentDAO();
    public abstract ProposalDAO createProposalDAO();
    public abstract RoleDAO createRoleDAO();
    public abstract TagDAO createTagDAO();
    public abstract UserDAO createUserDAO();
    public abstract VoteDAO createVoteDAO();

}
