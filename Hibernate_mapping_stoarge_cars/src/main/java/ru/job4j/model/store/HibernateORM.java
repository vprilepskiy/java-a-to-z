package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.entity.Car;
import ru.job4j.model.entity.VIN;

import java.util.List;

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




//    public List<Object> getRows(Class c) {
//        List<Object> objects;
//
//        try (final Session session = this.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            String hql = "from " + c.getName();
//
//            objects = session.createQuery(hql, c).list();
//            session.getTransaction().commit();
//        }
//        return objects;
//    }
//
//
//    public void setRowsForSelectedObject() {
//
//        try (final Session session = HibernateORM.getInstance().sessionFactory.openSession()) {
//            session.beginTransaction();
//            final List<Car> cars = session.createQuery("from Car", Car.class).list();
//            session.getTransaction().commit();
//        }
//    }
//
//
//
//    public void saveOrUpdate(Object o) {
//        try (final Session session = this.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            // item in state "Transient"
//            session.saveOrUpdate(o);
//            // now item in state "Persistent"
//            session.getTransaction().commit();
//        }
//        // session.close();
//        // now item in state "Detached"
//    }


    /**
     * Close session factory.
     */
    public void close() {
        this.getSessionFactory().close();
    }
}
