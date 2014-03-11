package up.voteme.dao;

import up.voteme.service.*;

public abstract class DAOFactory {
    public static final int HibernateDAO = 0;

    public static DAOFactory getFactory(int whichFactory) {
        switch(whichFactory) {
            case HibernateDAO:
                return new HibernateDAOFactory();

            default:
                return new HibernateDAOFactory();
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
