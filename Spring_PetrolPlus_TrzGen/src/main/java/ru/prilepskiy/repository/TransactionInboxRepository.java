package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.TransactionInbox;

/**
 * Created by VLADIMIR on 22.05.2018.
 */
public interface TransactionInboxRepository extends CrudRepository<TransactionInbox, String> {



}
