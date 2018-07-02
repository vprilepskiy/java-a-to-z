package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Client;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
}
