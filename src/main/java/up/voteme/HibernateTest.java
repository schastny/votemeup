package up.voteme;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.Attachment;
import up.voteme.domain.Proposal;
import up.voteme.domain.Role;
import up.voteme.domain.User;
import up.voteme.util.HibernateUtil;

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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Role admin = new Role();
        admin.setRole("admin");

        Role user = new Role();
        user.setRole("user");

        User user0 = new User();
        user0.setCity("Yalta");
        user0.setDateOfBirth(new Date());
        user0.setLogin("st1ch");
        user0.setRole(admin);

        User user1 = new User();
        user1.setCity("Sevastopol");
        user1.setDateOfBirth(new Date());
        user1.setLogin("voodoo");
        user1.setRole(user);

        admin.getUsers().add(user0);
        user.getUsers().add(user1);

        Proposal proposal0 = new Proposal();
        proposal0.setAuthor(user0);

        Attachment attachment0 = new Attachment();
        attachment0.setPath("fjhskl");
        attachment0.setUrl("5432tgsdl");
        attachment0.setProposal(proposal0);

        Attachment attachment1 = new Attachment();
        attachment1.setPath("tgewrhg");
        attachment1.setUrl("3245h");
        attachment1.setProposal(proposal0);

        Attachment attachment2 = new Attachment();
        attachment2.setPath(",likg");
        attachment2.setUrl("434ha");
        attachment2.setProposal(proposal0);

        proposal0.getAttachments().add(attachment0);
        proposal0.getAttachments().add(attachment1);
        proposal0.getAttachments().add(attachment2);

        session.save(attachment0);
        session.save(attachment1);
        session.save(attachment2);
        session.save(proposal0);

        session.save(user0);
        session.save(user1);
        session.save(admin);
        session.save(user);

        session.getTransaction().commit();
        session.close();

//        System.out.println(proposal0.getAttachments().toString());

        sessionFactory.close();
    }
}