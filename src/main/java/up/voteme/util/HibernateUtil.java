package up.voteme.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 01.03.14
 * Time: 12:35
 * Package name: up.voteme
 * Project name: votemeup
 */
public class HibernateUtil
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new AnnotationConfiguration().configure()
                                                .buildSessionFactory();
        } catch(Throwable e)
        {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
