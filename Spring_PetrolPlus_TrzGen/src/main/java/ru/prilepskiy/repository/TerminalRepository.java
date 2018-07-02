package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Terminal;
import ru.prilepskiy.domain.TerminalPK;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
public interface TerminalRepository extends CrudRepository<Terminal, TerminalPK> {

    Terminal findFirstByIdEmitentAndIdFilialAndIdTo (long idEmitent, long idFilial, long idTo);

}
