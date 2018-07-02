package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.CardService;
import ru.prilepskiy.domain.CardServicePK;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface CardServiceRepository extends CrudRepository<CardService, CardServicePK> {

    /**
     * Найти все кошкльки по idKarty.
     * @param idKarty
     * @return
     */
    Iterable<CardService> findByIdKarty(Long idKarty);

}
