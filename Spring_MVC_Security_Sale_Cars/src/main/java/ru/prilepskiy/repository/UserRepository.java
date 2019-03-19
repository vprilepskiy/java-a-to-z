package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Iterable<UserEntity> findByLoginAndPassword(String login, String password);

    Iterable<UserEntity> findByLogin(String login);

}
