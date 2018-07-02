package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.TransactionStorage;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface TransactionStorageRepository extends CrudRepository<TransactionStorage, String> {


}
