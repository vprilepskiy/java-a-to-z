package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.TransactionLocal;
import ru.prilepskiy.repository.TransactionLocalRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by VLADIMIR on 30.05.2018.
 */
@Service
public class TransactionLocalService {

    @Autowired
    TransactionLocalRepository transactionLocalRepository;

    public Iterable<TransactionLocal> findByDataBetweenAndGrNomer(Date endData, Date startData, long grNomer) {
        return this.transactionLocalRepository.findByDataBetweenAndGrNomerOrderByDataAscVremyaAsc(endData, startData, grNomer);
    }
}
