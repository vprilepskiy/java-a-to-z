package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entity.User;
import ru.job4j.model.store.defaultData.Marks;

/**
 * Created by VLADIMIR on 05.03.2018.
 */
public class HibernateORMTest {
    @Before
    public void setUp() throws Exception {
        HibernateORM.getInstance().setUp();
    }


    @Test
    public void getSessionFactory() throws Exception {
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            final String hql = "from User where login = :login and password = :password";


            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("login", "a");
            query.setParameter("password", "a");
            User user = query.uniqueResult();
            System.out.println(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aVoid() {
        for (Marks mark : Marks.values()) {
            System.out.println(mark.getMark());
            System.out.println(mark.getMark().getModels());
        }
    }


    @After
    public void tearDown() throws Exception {
        HibernateORM.getInstance().close();
    }


}