package ru.prilepskiy.repository;

import ru.prilepskiy.entity.ItemsEntity;
import ru.prilepskiy.entity.MarksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public List<ItemsEntity> getItems(boolean today, boolean withPhoto, int markId, boolean active) {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<ItemsEntity> queryRoot = builder.createQuery(ItemsEntity.class);
        final Root<ItemsEntity> root = queryRoot.from(ItemsEntity.class);
        queryRoot.select(root);

        // условия выборки
        List<Predicate> predicates = new LinkedList<>();
        // только активные
        if (active) {
            predicates.add(builder.equal(root.get("active"), active));
        }
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
            MarksEntity mark = marksRepository.findById(markId).get();
            predicates.add(builder.equal(root.get("mark"), mark));
        }

        // установить условия
        queryRoot.where(builder.and(
            predicates.toArray(new Predicate[predicates.size()])
        ));

        // сортировать по id.
        queryRoot.orderBy(builder.asc(root.get("id")));

        List<ItemsEntity> resultList = this.entityManager.createQuery(queryRoot).getResultList();

        return resultList;
    }

    /**
     * Beginning of today.
     * @return - time value in milliseconds.
     */
    private Timestamp startOfDay() {
        return new Timestamp(0);
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
}
