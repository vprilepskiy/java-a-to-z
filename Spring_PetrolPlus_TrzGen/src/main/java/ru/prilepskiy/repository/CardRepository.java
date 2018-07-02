package ru.prilepskiy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Card;

import java.util.List;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface CardRepository extends CrudRepository<Card, Long> {

    /**
     * Найти первую запись по типу карты.
     * @param tipKarty
     * @return
     */
    Card findFirstByTipKarty(long tipKarty);

    /**
     * Найти первую запись по типу карты и
     * @param tipKarty
     * @param grNomer
     * @return
     */
    Card findFirstByTipKartyAndGrNomer(long tipKarty, long grNomer);


    @Query(value = "select t.ID_FIRMY, t.NAME from Ecfil002 as t", nativeQuery = true)
    Iterable<Object[]> getArray();


//    @Query("select u.id, LENGTH(u.firstname) as fn_len from User u where u.lastname like ?1%")
//    List<Object[]> findByAsArrayAndSort(String lastname, Sort sort);

}










