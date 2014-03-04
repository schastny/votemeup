package up.voteme;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import up.voteme.domain.*;
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

        Tag tag1 = new Tag();
        tag1.setId(5);
        tag1.setTitle("title1");

        Tag tag2 = new Tag();
        tag2.setId(6);
        tag2.setTitle("title2");

        Tag tag3 = new Tag();
        tag3.setId(7);
        tag3.setTitle("title3");

        Comment com1 = new Comment();
        com1.setId(1);
        com1.setAuthor(user0);
        com1.setProposal(proposal0);

        Comment com2 = new Comment();
        com2.setId(2);
        com2.setAuthor(user1);
        com2.setProposal(proposal0);

        Comment com3 = new Comment();
        com3.setId(3);
        com3.setAuthor(user0);
        com3.setProposal(proposal0);

        Category cat0 = new Category();
        cat0.setTitle("category0");
        cat0.setId(0);

        Category cat1 = new Category();
        cat1.setTitle("category1");
        cat1.setId(1);

        Category cat2 = new Category();
        cat2.setTitle("category2");
        cat2.setId(2);


        Vote vote0 = new Vote();
        vote0.setId(0);
        vote0.setUser(user0);
        vote0.setProposal(proposal0);

        Vote vote1 = new Vote();
        vote1.setId(1);
        vote1.setUser(user1);
        vote1.setProposal(proposal0);

        Vote vote2 = new Vote();
        vote2.setId(2);
        vote2.setUser(user0);
        vote2.setProposal(proposal0);

        proposal0.getCategories().add(cat0);
        proposal0.getCategories().add(cat1);
        proposal0.getCategories().add(cat2);

        proposal0.getTags().add(tag1);
        proposal0.getTags().add(tag2);
        proposal0.getTags().add(tag3);

        proposal0.getComments().add(com1);
        proposal0.getComments().add(com2);
        proposal0.getComments().add(com3);

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

        session.save(cat0);
        session.save(cat1);
        session.save(cat2);

        session.save(tag1);
        session.save(tag2);
        session.save(tag3);

        session.save(com1);
        session.save(com2);
        session.save(com3);

        session.save(vote0);
        session.save(vote1);
        session.save(vote2);

        session.getTransaction().commit();
        session.close();

//        System.out.println(proposal0.getAttachments().toString());

        sessionFactory.close();
        System.exit(0);
    }
}