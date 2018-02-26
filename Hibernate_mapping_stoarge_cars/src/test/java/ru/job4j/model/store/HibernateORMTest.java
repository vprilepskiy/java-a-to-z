package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entity.Car;
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
        vesta.getVins().add(new VIN("V123"));
        vesta.getVins().add(new VIN("V456"));

        Car xRay = new Car("Lada", "xRay");
        xRay.setVins(new HashSet<>());
        xRay.getVins().add(new VIN("x123"));
        xRay.getVins().add(new VIN("x456"));

        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            // delete old rows
            session.createQuery("delete from VIN").executeUpdate();
            session.createQuery("delete from Car").executeUpdate();
            // add new rows
            session.saveOrUpdate(vesta);
            session.saveOrUpdate(xRay);

            session.getTransaction().commit();
        }

        // disconnect ... new connect

        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            final List<Car> cars = session.createQuery("from Car", Car.class).list();

            System.out.println("Cars: " + cars);
            System.out.println("Vin: = " + cars.get(0).getVins());

            session.getTransaction().commit();
        }
    }


    @Test
    public void setRowsForSelectedObject() {
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Car> cars = session.createQuery("from Car", Car.class).list();
//            List<VIN> vins = new LinkedList<>();
//            vins.add(new VIN("V123"));

            System.out.println("vins: " + cars.get(0).getVins());

            System.out.println("cars: " + cars);
            session.getTransaction().commit();
        }
    }


    @After
    public void tearDown() throws Exception {
        HibernateORM.getInstance().close();
    }

}