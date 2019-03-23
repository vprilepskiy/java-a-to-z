package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.prilepskiy.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserDetails findByUsername(String username);

    UserEntity findFirstByUsername(String username);
}
