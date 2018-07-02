package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Personnel;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {

    /**
     * Найти запись по уровню доступа.
     * @param idUrovnyaDostupa
     * @return
     */
    Personnel findFirstByIdUrovnyaDostupa(long idUrovnyaDostupa);

}
