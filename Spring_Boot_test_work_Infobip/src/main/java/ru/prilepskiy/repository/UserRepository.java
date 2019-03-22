package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findFirstByLogin(String login);

}
