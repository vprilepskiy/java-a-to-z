package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.P5Config;

/**
 * Created by VLADIMIR on 22.05.2018.
 */
public interface P5ConfigRepository extends CrudRepository <P5Config, Long> {

    /**
     * Получить первую запись, сортировать по IdEmitent.
     * @return
     */
    P5Config findFirstByOrderByIdEmitentAsc();

}
