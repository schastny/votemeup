package up.voteme;


import up.voteme.dao.DAOFactory;
import up.voteme.domain.*;
import up.voteme.service.*;

import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) throws Exception {

        DAOFactory factory = DAOFactory.getFactory(DAOFactory.HibernateDAO);

        UserDAO userDAO = factory.createUserDAO();
        AttachmentDAO attachmentDAO = factory.createAttachmentDAO();
        RoleDAO roleDAO = factory.createRoleDAO();
        AddressDAO addressDAO = factory.createAddressDAO();

        Role admin = new Role();
        admin.setRole("admin");

        Role user = new Role();
        user.setRole("user");

        User ivan = new User();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Saprykin");
        ivan.setLogin("eggplant");
        ivan.setPassword("123");
        ivan.setEmail("redtube@mail.com");
        ivan.setDateOfBirth(new Date());
        ivan.setRole(admin);

        Address address1 = new Address();
        address1.setCountry("Ukraine");
        address1.setCity("Kiev");
        address1.setStreet("Tarasa Shevchenko Boulevard");

        ivan.setAddress(address1);

        User sasha = new User();
        sasha.setFirstName("Sasha");
        sasha.setLastName("Koval");
        sasha.setPassword("123");
        sasha.setLogin("pussy");
        sasha.setEmail("homeless@mail.com");
        sasha.setDateOfBirth(new Date());
        sasha.setRole(user);

        Address address2 = new Address();
        address2.setCountry("Russia");
        address2.setCity("Moscow");
        address2.setStreet("Lenina street");

        sasha.setAddress(address2);

        addressDAO.addAddress(address1);
        addressDAO.addAddress(address2);

        userDAO.addUser(ivan);
        userDAO.addUser(sasha);


        System.out.println(userDAO.getAllUsers().get(0).getRole());
        System.out.println(userDAO.getAllUsers().get(1).getRole());

        // testing VoteHibernateDao

        System.out.println("testing VoteHibernateDao");

        Proposal proposal = new Proposal();
        proposal.setTitle("Proposal");
        proposal.setContent("asdf");

        Proposal proposal1 = new Proposal();
        proposal1.setTitle("Proposal1");
        proposal1.setContent("sdfafff");

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

        proposalDAO1.deleteProposal(proposal);

        // testing RoleHibernateDao

        System.out.println("\n\n testing VoteHibernateDao");

        // getProposalsByTag

        System.out.println("proposalDAO1.getProposalsByTag(tag)" + proposalDAO1.getProposalsByTag(tag));



        System.exit(0);
    }
}