package up.voteme;


import up.voteme.dao.DAOFactory;
import up.voteme.domain.*;
import up.voteme.service.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 01.03.14
 * Time: 13:15
 * Package name: up.voteme
 * Project name: votemeup
 */
public class HibernateTest
{
    public static void main(String[] args) throws Exception
    {
        DAOFactory factory = DAOFactory.getFactory(DAOFactory.HibernateDAO);
        UserDAO userDAO = factory.createUserDAO();
        ProposalDAO proposalDAO = factory.createProposalDAO();
        AttachmentDAO attachmentDAO = factory.createAttachmentDAO();
        RoleDAO roleDAO = factory.createRoleDAO();

        Role admin = new Role();
        admin.setRole("admin");

        Role user = new Role();
        user.setRole("user");

        User ivan = new User();
        ivan.setLogin("eggplant");
        ivan.setEmail("redtube@mail.com");
        ivan.setCity("Shkolnoe");
        ivan.setDateOfBirth(new Date());
        ivan.setRole(admin);

        User sasha = new User();
        sasha.setLogin("pussy");
        sasha.setEmail("homeless@mail.com");
        sasha.setCity("Yalta");
        sasha.setDateOfBirth(new Date());
        sasha.setRole(user);

        userDAO.addUser(ivan);
        userDAO.addUser(sasha);

        System.out.println(userDAO.getAllUsers().get(0).getRole());
        System.out.println(userDAO.getAllUsers().get(1).getRole());

        // testing VoteHibernateDao

        System.out.println("testing VoteHibernateDao");

        Proposal proposal = new Proposal();
        proposal.setTitle("Proposal");

        Proposal proposal1 = new Proposal();
        proposal1.setTitle("Proposal1");

        Tag tag = new Tag();
        tag.setTitle("Pron");
        tag.getProposals().add(proposal);
        tag.getProposals().add(proposal1);

        proposal.getTags().add(tag);
        proposal1.getTags().add(tag);

        //proposal.setAuthor(ivan);

        Date date = new Date();

        Vote vote1 = new Vote();
        vote1.setDate(date);
        Vote vote2 = new Vote();
        vote2.setDate(date);
        vote1.setUser(ivan);

        vote1.setProposal(proposal);
        proposal.getVotes().add(vote1);

        TagDAO tagDAO = factory.createTagDAO();
        tagDAO.addTag(tag);

        ProposalDAO proposalDAO1 = factory.createProposalDAO();
        proposalDAO1.addProposal(proposal);
        proposalDAO1.addProposal(proposal1);


        VoteDAO voteDAO = factory.createVoteDAO();
        voteDAO.addVote(vote1);
        voteDAO.addVote(vote2);

        System.out.println("voteDAO.getAllVotesByProposal(proposal)" + voteDAO.getAllVotesByProposal(proposal));
        System.out.println("voteDAO.getAllVotesByUser(ivan)" + voteDAO.getAllVotesByUser(new User()));
        System.out.println("voteDAO.getAllVotesByDate(date)" + voteDAO.getAllVotesByDate(date));

        //proposalDAO1.deleteProposal(proposal);

        // testing RoleHibernateDao

        System.out.println("/n/n testing VoteHibernateDao");

        // getProposalsByTag

        System.out.println("proposalDAO1.getProposalsByTag(tag)" + proposalDAO1.getProposalsByTag(tag));



        System.exit(0);
    }
}