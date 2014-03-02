package up.voteme;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        session.save(user0);
        session.save(user1);
        session.save(admin);
        session.save(user);

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}