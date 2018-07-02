package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Transaction;

/**
 * Created by VLADIMIR on 21.05.2018.
 */
public interface TransactionRepository extends CrudRepository<Transaction, String> {


}
