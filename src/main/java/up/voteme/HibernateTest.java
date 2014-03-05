package up.voteme;


import up.voteme.dao.DAOFactory;
import up.voteme.domain.Attachment;
import up.voteme.domain.Proposal;
import up.voteme.domain.User;
import up.voteme.service.AttachmentDAO;
import up.voteme.service.ProposalDAO;
import up.voteme.service.UserDAO;

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
    public static void main(String[] args)
    {
        DAOFactory factory = DAOFactory.getFactory(DAOFactory.HibernateMySqlDAO);
        UserDAO userDAO = factory.createUserDAO();
        ProposalDAO proposalDAO = factory.createProposalDAO();
        AttachmentDAO attachmentDAO = factory.createAttachmentDAO();


        User ivan = new User();
        ivan.setLogin("eggplant");
        ivan.setEmail("redtube@mail.com");
        ivan.setCity("Shkolnoe");
        ivan.setDateOfBirth(new Date());

        userDAO.addUser(ivan);

        User sasha = new User();
        sasha.setLogin("pussy");
        sasha.setEmail("homeless@mail.com");
        sasha.setCity("Yalta");
        sasha.setDateOfBirth(new Date());

        userDAO.addUser(sasha);

        Proposal proposal = new Proposal();
        proposal.setTitle("title");
        proposal.setContent("content");

        Attachment attachment = new Attachment();
        attachment.setPath("hfhjsd");
        attachment.setUrl("http://localhost");
        attachment.setProposal(proposal);


        proposal.getAttachments().add(attachment);


        attachmentDAO.addAttachment(attachment);
        proposalDAO.addProposal(proposal);


        System.out.println(attachmentDAO.getAllAttachmentsByProposal(proposal));

    }
}