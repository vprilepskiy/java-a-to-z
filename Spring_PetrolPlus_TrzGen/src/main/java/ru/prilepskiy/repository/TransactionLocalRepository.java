package ru.prilepskiy.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.TransactionLocal;

import java.sql.Date;
import java.util.List;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
public interface TransactionLocalRepository extends CrudRepository<TransactionLocal, String> {

    List<TransactionLocal> findByDataBetweenAndGrNomerOrderByDataAscVremyaAsc(Date endData, Date startData, long grNomer);

}
