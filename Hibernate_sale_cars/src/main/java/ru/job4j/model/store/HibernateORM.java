package ru.job4j.model.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by VLADIMIR on 14.02.2018.
 */
public class HibernateORM {

    /**
     * Static class INSTANCE.
     */
    private static final HibernateORM INSTANCE = new HibernateORM();

    /**
     * SessionFactory.
     */
    private SessionFactory sessionFactory;

    /**
     * Empty constructor.
     */
    private HibernateORM() {
    }

    /**
     * Getter.
     *
     * @return - Class INSTANCE
     */
    public static HibernateORM getInstance() {
        return INSTANCE;
    }


    /**
     * Set configure.
     */
    public void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }


    /**
     * Get session.
     * @return
     */
    public SessionFactory getSessionFactory() {
        if (this.sessionFactory == null) {
            throw new NullPointerException();
        }
        return this.sessionFactory;
    }


    /**
     * Close session factory.
     */
    public void close() {
        this.getSessionFactory().close();
    }
}
