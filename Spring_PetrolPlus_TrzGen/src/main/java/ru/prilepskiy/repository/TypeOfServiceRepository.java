package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.TypeOfService;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface TypeOfServiceRepository extends CrudRepository<TypeOfService, Long> {

    Iterable<TypeOfService> findByActivnostAndCurrency(boolean activnost, boolean isCurrency);

    TypeOfService findFirstByIdUslugiAndActivnostAndCurrency(long idUslugi, boolean activnost, boolean isCurrency);

}
