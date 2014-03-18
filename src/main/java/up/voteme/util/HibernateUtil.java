package up.voteme.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    private static StandardServiceRegistryBuilder registryBuilder;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(registryBuilder.build());
        } catch(Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static Session getSession() {
        return  HibernateUtil.SESSION_FACTORY.getCurrentSession();
    }

    public static void begin() {
        getSession().beginTransaction();
    }

    public static void commit() {
        getSession().getTransaction().commit();
    }

    public static void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch(HibernateException e) {
            System.out.println("Cannot rollback: " + e);
        }
        try {
            getSession().close();
        } catch(HibernateException e) {
            System.out.println("Cannot close: " + e);
        }
    }

    public static void closeSession() {
        getSession().close();
    }
}


/*
        http://somejavaexamples.blogspot.com/2013/06/difference-between-opensession.html

        private static ServiceRegistry serviceRegistry;

        Configuration configuration = new Configuration().configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);

        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);

        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(builder);
*/