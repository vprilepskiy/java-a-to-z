package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.entity.Item;
import java.util.List;

/**
 * Created by VLADIMIR on 14.02.2018.
 */
public class HibernateORM  {

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
    private SessionFactory getSessionFactory() {
        if (this.sessionFactory == null) {
            throw new NullPointerException();
        }
        return this.sessionFactory;
    }


    /**
     * Get items.
     * @param all - if false then view done.
     * @return - items.
     */
    public List<Item> getItems(boolean all) {
        List<Item> items;

        try (final Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql;
            if (all) {
                hql = "from Item order by id";
            } else {
                hql = "from Item where done = true order by id";
            }

            items = session.createQuery(hql, Item.class).list();
            session.getTransaction().commit();
        }
        return items;
    }


    /**
     * Save or update.
     * @param item - item.
     */
    public void saveOrUpdate(Item item) {
        try (final Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();
            // item in state "Transient"
            session.saveOrUpdate(item);
            // now item in state "Persistent"
            session.getTransaction().commit();
        }
        // session.close();
        // now item in state "Detached"
    }


    /**
     * Close session factory.
     */
    public void close() {
        this.getSessionFactory().close();
    }
}
