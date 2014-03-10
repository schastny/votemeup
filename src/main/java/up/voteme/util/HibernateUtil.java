package up.voteme.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
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
    private static final ThreadLocal session = new ThreadLocal();

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

    public static Session getSession()
    {
        Session session = (Session)HibernateUtil.session.get();
        if(session == null)
        {
            session = sessionFactory.openSession();
            HibernateUtil.session.set(session);
        }
        return session;
    }

    public static void begin()
    {
        getSession().beginTransaction();
    }

    public static void commit()
    {
        getSession().getTransaction().commit();
    }

    public static void rollback()
    {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            System.out.println("Cannot rollback: " + e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            System.out.println("Cannot close: " + e);
        }
        HibernateUtil.session.set(null);
    }

    public static void closeSession()
    {
        getSession().close();
        HibernateUtil.session.set(null);
    }
}
