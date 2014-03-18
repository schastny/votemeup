package up.voteme;


import up.voteme.dao.DAOFactory;
import up.voteme.domain.*;
import up.voteme.service.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class HibernateTest {

    public static void main(String[] args) throws Exception {

        DAOFactory factory = DAOFactory.getFactory(DAOFactory.HibernateDAO);

        UserDAO userDAO = factory.createUserDAO();
        AttachmentDAO attachmentDAO = factory.createAttachmentDAO();
        RoleDAO roleDAO = factory.createRoleDAO();
        AddressDAO addressDAO = factory.createAddressDAO();
        CommentDAO commentDAO = factory.createCommentDAO();
        CategoryDAO categoryDAO = factory.createCategoryDAO();

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


        //System.out.println(userDAO.getAllUsers().get(0).getRole());
        //System.out.println(userDAO.getAllUsers().get(1).getRole());

        // testing VoteHibernateDao

        System.out.println("testing VoteHibernateDao");

        Proposal proposal = new Proposal();
        proposal.setTitle("Proposal");
        proposal.setContent("asdf");

        Proposal proposal1 = new Proposal();
        proposal1.setTitle("Proposal1");
        proposal1.setContent("sdfafff");

        Comment comment = new Comment();
        comment.setContent("wtf?");
        comment.setProposal(proposal);

        Attachment attachment1 = new Attachment();
        attachment1.setUrl("google.com");

        Attachment attachment2 = new Attachment();
        attachment2.setUrl("yandex.ru");

        Attachment attachment3 = new Attachment();
        attachment3.setUrl("bing.com");

        proposal.getAttachments().add(attachment1);
        proposal.getAttachments().add(attachment2);

        comment.getAttachments().add(attachment3);
        comment.getAttachments().add(attachment2);

        attachmentDAO.addAttachment(attachment1);
        attachmentDAO.addAttachment(attachment2);
        attachmentDAO.addAttachment(attachment3);


        Category category1 = new Category();
        category1.setTitle("Sport");
        Category category2 = new Category();
        category2.setTitle("Education");
        Category category3 = new Category();
        category3.setTitle("Children");

        proposal.getCategories().add(category1);
        proposal.getCategories().add(category2);
        proposal1.getCategories().add(category2);
        proposal1.getCategories().add(category3);

        categoryDAO.addCategory(category1);
        categoryDAO.addCategory(category2);
        categoryDAO.addCategory(category3);

        ProposalDAO proposalDAO1 = factory.createProposalDAO();
        proposalDAO1.addProposal(proposal);
        proposalDAO1.addProposal(proposal1);

        commentDAO.addComment(comment);



        //proposal.setAuthor(ivan);

        Date date = new Date();

        Vote vote1 = new Vote();
        vote1.setDate(date);
        Vote vote2 = new Vote();
        vote2.setDate(date);
        vote1.setUser(ivan);

        vote1.setProposal(proposal);
        proposal.getVotes().add(vote1);



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

        List<User> users = userDAO.getAllUsers();
        Set<Proposal> proposals = users.get(0).getProposals();
        User u = proposals.iterator().next().getAuthor();
        System.out.println(u);
        //System.out.println(proposals);
        //System.out.println(users.get(0).getVotes());

        System.exit(0);
    }
}