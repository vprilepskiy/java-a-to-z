package ru.job4j.model.store.defaultData;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.job4j.model.entity.Mark;
import ru.job4j.model.entity.Model;
import ru.job4j.model.store.HibernateORM;

/**
 * Created by VLADIMIR on 15.03.2018.
 */
public class AddEnums {

    public void bodyTypes() {
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            for (BodyTypes bodyType : BodyTypes.values()) {
                Query query = session.createQuery("from BodyType where description = :description");
                query.setParameter("description", bodyType.getBodyType().getDescription());

                if (query.list().isEmpty()) {
                    session.save(bodyType.getBodyType());
                }
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void cars() {
        try (final Session session = HibernateORM.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();

            for (Marks marks : Marks.values()) {

                // запросить Mark
                Query query = session.createQuery("from Mark where description = :description");
                query.setParameter("description", marks.getMark().getDescription());

                // если такой марки нет то добавить
                if (query.list().isEmpty()) {

                    // add parent
                    Mark mark = marks.getMark();

                    // add children
                    for (Model model : mark.getModels()) {
                        session.saveOrUpdate(model);
                    }

                    session.saveOrUpdate(mark);
                }

            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
