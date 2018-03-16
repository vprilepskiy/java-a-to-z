package ru.job4j.model.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import ru.job4j.model.entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.*;

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
     * @return - SessionFactory.
     */
    public SessionFactory getSessionFactory() {
        if (this.sessionFactory == null) {
            throw new NullPointerException();
        }
        return this.sessionFactory;
    }


    /**
     * Add photo in Item.
     * @param photo - photo(int id, photo byte[])
     */
    public void updatePhoto(Item photo) {
        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            Item item = session.get(Item.class, photo.getId());
            item.setPhoto(photo.getPhoto());

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Add item.
     * @param sessionUser - User.
     * @param markId - id mark.
     * @param modelId - id model.
     * @param bodyTypeId - id body type.
     * @param year - year.
     * @param price - price.
     */
    public void addItem(User sessionUser, int markId, int modelId, int bodyTypeId, int year, int price) {
        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            Mark mark = session.get(Mark.class, markId);
            Model model = session.get(Model.class, modelId);
            BodyType bodyType = session.get(BodyType.class, bodyTypeId);

            ru.job4j.model.entity.Item item = new ru.job4j.model.entity.Item();
            item.setMark(mark);
            item.setModel(model);
            item.setBodyType(bodyType);
            item.setYear(year);
            item.setPrice(price);
            item.setActive(true);
            item.setCreated(new Timestamp(System.currentTimeMillis()));

            // добавить объявление
            int id = (int) session.save(item);

            // привязать это объявление к текущему юзеру.
            session.get(User.class, sessionUser.getId()).getItems().add(item);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Get User by Login/Password.
     * @param login - login.
     * @param password - password.
     * @return - user.
     */
    public User getUserByLoginPass(String login, String password) {
        User result = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            final String hql = "from User where login = :login and password = :password";

            final Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);

            result = query.uniqueResult();

            session.getTransaction().commit();
        }

        return result;
    }


    /**
     * Add User by Login/Password.
     * @param login - login.
     * @param password - password.
     * @return - new User if not exists.
     */
    public User addUser(String login, String password) {
        User user = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            user = new User(login, password);
            int id = (int) session.save(user);

            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            // если нарушено условие уникальности
            user = null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


    /**
     * Set active parameter.
     * @param itemId - id item.
     * @param state - parameter.
     */
    public void setActive(int itemId, boolean state) {
        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            Item item = session.get(Item.class, itemId);
            item.setActive(state);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Get body types.
     * @return - bodyTypes.
     */
    public List<BodyType> getBodyTapes() {
        List<BodyType> bodyTypes = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            bodyTypes = session.createQuery("from BodyType", BodyType.class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bodyTypes;
    }


    /**
     * Get items by condition.
     * @param today - only today.
     * @param withPhoto - only with Photo.
     * @param markId - on mark Id.
     * @return - items.
     */
    public List<Item> getItems(boolean today, boolean withPhoto, int markId) {
        List<Item> items = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            final CriteriaBuilder builder = session.getCriteriaBuilder();
            final CriteriaQuery<Item> queryRoot = builder.createQuery(Item.class);
            final Root<Item> root = queryRoot.from(Item.class);
            queryRoot.select(root);

            // условия выборки
            List<Predicate> predicates = new LinkedList<>();
            // только активные
            predicates.add(builder.equal(root.get("active"), true));
            // за сегодня
            if (today) {
                predicates.add(builder.between(root.get("created"), this.startOfDay(), this.endOfDay()));
            }
            // только с фото
            if (withPhoto) {
                predicates.add(builder.isNotNull(root.get("photo")));
            }
            // определенной марки
            if (markId != 0) {
                Mark mark = session.get(Mark.class, markId);
                predicates.add(builder.equal(root.get("mark"), mark));
            }

            // установить условия
            queryRoot.where(builder.and(
                    predicates.toArray(new Predicate[predicates.size()])
            ));

            // сортировать по id.
            queryRoot.orderBy(builder.asc(root.get("id")));

            Query<Item> query = session.createQuery(queryRoot);
            items = query.list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }


    /**
     * Beginning of today.
     * @return - time value in milliseconds.
     */
    private Timestamp startOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * End of today.
     * @return - time value in milliseconds.
     */
    private Timestamp endOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * Get marks.
     * @return - marks.
     */
    public List<Mark> getMarks() {
        List<Mark> marks = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            marks = session.createQuery("from Mark", Mark.class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marks;
    }


    /**
     * Get items by user id.
     * @param user - user.
     * @return - items.
     */
    public Set<Item> getItems(User user) {
        Set<Item> items = null;

        try (Session session = this.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query<User> query = session.createQuery("from User where id = :id");
            query.setParameter("id", user.getId());
            user = query.uniqueResult();
            items = user.getItems();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }



    /**
     * Close session factory.
     */
    public void close() {
        this.getSessionFactory().close();
    }
}
