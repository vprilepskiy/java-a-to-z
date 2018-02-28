package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entity.Car;
import ru.job4j.model.entity.SalesOrder;
import ru.job4j.model.entity.VIN;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 20.02.2018.
 */
public class HibernateORMTest {

    @Before
    public void setUp() throws Exception {
        HibernateORM.getInstance().setUp();
    }


    @Test
    public void setRows() {
        Car vesta = new Car("Lada", "Vesta");
        vesta.setVins(new HashSet<>());
        vesta.getVins().add(new VIN("V123", vesta, null));
        vesta.getVins().add(new VIN("V456", vesta, null));

        Car xRay = new Car("Lada", "xRay");
        xRay.setVins(new HashSet<>());
        xRay.getVins().add(new VIN("x123", xRay, null));
        xRay.getVins().add(new VIN("x456", xRay, null));

        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            // delete old rows
            session.createQuery("delete from VIN").executeUpdate();
            session.createQuery("delete from Car").executeUpdate();
            session.createQuery("delete from SalesOrder").executeUpdate();
            session.createQuery("delete from Options").executeUpdate();

            // add new rows
            session.save(vesta);
            session.save(xRay);

            session.getTransaction().commit();
        }

        // disconnect ... new connect
        // assert Cars and VIN.
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            final List<Car> cars = session.createQuery("from Car", Car.class).list();

            assertTrue(cars.contains(vesta));
            assertTrue(cars.contains(xRay));

            assertTrue(cars.get(0).getVins().contains(new VIN("V123", vesta, null)));

            session.getTransaction().commit();
        }


        // disconnect ... new connect
        // add sales order
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            int i = 0;
            final List<Car> cars = session.createQuery("from Car", Car.class).list();
            for (Car car : cars) {
                for (VIN vin : car.getVins()) {
                    SalesOrder order = new SalesOrder(i++);
                    session.saveOrUpdate(order);
                    vin.setSalesOrder(order);
                }
            }

            session.getTransaction().commit();
        }
    }


    @Test
    public void test() {
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            // create structure if hibernate.hbm2ddl.auto = "update"

            session.getTransaction().commit();
        }
    }


    @After
    public void tearDown() throws Exception {
        HibernateORM.getInstance().close();
    }

}